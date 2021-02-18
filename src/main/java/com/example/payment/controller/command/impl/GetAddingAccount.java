package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetAddingAccount implements Command {
    private static final String URL = "/addAccount.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return URL;
    }
}
