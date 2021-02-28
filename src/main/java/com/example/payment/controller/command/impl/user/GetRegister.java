package com.example.payment.controller.command.impl.user;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetRegister implements Command {

    private static final String URL = "/register.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        return URL;
    }
}
