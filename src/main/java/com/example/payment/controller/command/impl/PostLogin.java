package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.PostCommand;
import com.example.payment.entity.User;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostLogin implements PostCommand {

    private final UserService userService = new UserServiceImpl();
    private static final String URL_ERROR = "/login.jsp";
    private static final String URL_SUCCESS = "/accounts";
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(userService.checkRegistered(email,password)){
            userService.getUser(email).ifPresent(user -> {
                request.getSession().setAttribute("LoggedUser",user);
            });
            request.setAttribute("logout" , false);
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }
    @Override
    public  boolean isError(String url){
        return url.equals(URL_ERROR);
    }
}