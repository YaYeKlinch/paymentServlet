package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetLogout implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("logout" , true);
        return "login.jsp";
    }
}
