package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetLogin implements Command {

    private static final String URL = "/login.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        return URL;
    }
}
