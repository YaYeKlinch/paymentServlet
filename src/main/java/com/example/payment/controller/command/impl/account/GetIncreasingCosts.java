package com.example.payment.controller.command.impl.account;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetIncreasingCosts implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/increaseCosts.jsp";
    }
}
