package com.example.payment.controller.command.impl.credit_card;

import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.validators.CardValidator;
import com.example.payment.entity.Account;
import com.example.payment.entity.CardType;
import com.example.payment.entity.dto.CardDto;
import com.example.payment.exception.AccountExistException;
import com.example.payment.service.account.AccountService;
import com.example.payment.service.account.AccountServiceImpl;
import com.example.payment.service.creditCard.CreditCardService;
import com.example.payment.service.creditCard.CreditCardServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostAddingCard implements PostCommand {
    boolean allMatches;
    CreditCardService cardService = new CreditCardServiceImpl();
    AccountService accountService = new AccountServiceImpl();
    private static final String URL_ERROR = "/addCard.jsp";
    private static final String URL_SUCCESS = "/accounts";

    @Override
    public String execute(HttpServletRequest request) {
        allMatches = true;
        long accountId = Long.parseLong(request.getParameter("account_id"));
        CardDto cardDto = getValidatedDto(request);
        boolean registered = createAndAddErrorAttributes(cardDto, accountId, request);
        if (registered) {
            request.setAttribute("values", cardDto);
            return URL_SUCCESS;
        }
        request.setAttribute("types", CardType.values());
        return URL_ERROR;
    }

    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }

    private boolean createAndAddErrorAttributes(CardDto cardDto, long accountId, HttpServletRequest request) {
        boolean registered = false;
        if (allMatches) {
            try {
                Account account = accountService.findAccountById(accountId);
                registered = tryCreateOrAddCreationErrorAttr(cardDto, request, account);
            } catch (AccountExistException ex) {
                request.setAttribute("cardCreateEx", true);
            }

        }
        return registered;
    }

    private boolean tryCreateOrAddCreationErrorAttr(CardDto cardDto, HttpServletRequest request, Account account) {
        if (cardService.createCard(account, cardDto)) {
            return true;
        } else {
            request.setAttribute("creationError", true);
            return false;
        }
    }

    private CardDto getValidatedDto(HttpServletRequest request) {
        CardDto cardDto = null;
        try {
            cardDto = new CardDto(
                    CardType.valueOf(request.getParameter("cardType")),
                    Integer.parseInt(request.getParameter("pin")),
                    Integer.parseInt(request.getParameter("confirmPin")));

            allMatches = CardValidator.validateCard(cardDto, request);

        } catch (IllegalArgumentException ex) {
            allMatches = false;
        }
        return cardDto;
    }
}
