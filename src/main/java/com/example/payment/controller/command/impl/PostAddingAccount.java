package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.validators.AccountValidator;
import com.example.payment.controller.command.impl.validators.UserValidator;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.AccountDto;
import com.example.payment.entity.dto.UserDto;
import com.example.payment.exception.EmailExistsException;
import com.example.payment.service.account.AccountService;
import com.example.payment.service.account.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.example.payment.controller.command.uttils.SessionUtils.getUserId;

public class PostAddingAccount implements PostCommand {
    boolean allMatches;
    private final AccountService accountService = new AccountServiceImpl();
    private static final String URL_ERROR = "/addAccount.jsp";
    private static final String URL_SUCCESS = "/accounts.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        allMatches = true;
        User user = getUserId(request);
        AccountDto accountDto = getValidatedDto(request);
        boolean registered = createAndAddErrorAttributes(accountDto ,user ,request);
        if(registered){
            request.setAttribute("values",accountDto);
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }

    private boolean createAndAddErrorAttributes(AccountDto accountDto , User user, HttpServletRequest request){
        boolean registered = false;
        if(allMatches){
            try{
                registered = tryCreateOrAddCreationErrorAttr(accountDto,request ,user);
            }catch (EmailExistsException ex){
                request.setAttribute("accountExists",true);
            }
        }
        return registered;
    }
    private boolean tryCreateOrAddCreationErrorAttr(AccountDto accountDto, HttpServletRequest request , User user){
        if(accountService.createAccount(accountDto , user)){
            return true;
        }else{
            request.setAttribute("creationError",true);
            return false;
        }
    }
    private AccountDto getValidatedDto(HttpServletRequest request) {
        AccountDto accountDto = null;
        try {
            accountDto = new AccountDto(
                    request.getParameter("number"),
                    request.getParameter("name"));

            AccountValidator.validateAccountDto(accountDto , request  ,allMatches);

        } catch (IllegalArgumentException ex) {
            allMatches = false;
        }
        return accountDto;
    }


    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }
}
