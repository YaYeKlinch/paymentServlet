package com.example.payment.controller.command.impl.credit_card;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.CardType;

import javax.servlet.http.HttpServletRequest;

public class GetAddingCard implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("types" , CardType.values());
        return "/addCard.jsp";
    }
}
