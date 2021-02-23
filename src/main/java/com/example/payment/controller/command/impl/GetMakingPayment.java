package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetMakingPayment implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "makePayment.jsp";
    }
}
