package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.CreditCard;
import com.example.payment.service.creditCard.CreditCardService;
import com.example.payment.service.creditCard.CreditCardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetCardsPage implements Command {
    CreditCardService creditCardService = new CreditCardServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        long accountId = Long.parseLong(request.getParameter("account_id"));
        List<CreditCard> cards  =  creditCardService.findAllCardsByAccount(accountId);
        request.setAttribute("cards" , cards);
        request.setAttribute("account_id" , accountId);
        return "/cards.jsp";
    }
}
