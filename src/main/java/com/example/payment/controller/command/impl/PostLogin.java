package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostLogin implements Command {

    private final UserService userService = new UserServiceImpl();
    private static final String URL_ERROR = "/login.jsp";
    private static final String URL_SUCCESS = "/accounts.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       // String requestedPage = getRequestedPage(request);
        if(userService.checkRegistered(email,password)){
            userService.getUser(email).ifPresent(user -> {
                request.getSession().setAttribute("LoggedUser",user);
            });
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }
    private String getRequestedPage(HttpServletRequest request){
        String url = request.getParameter("requestedUrl");
        if(url == null || url.startsWith("/login")){
            url = "/";
        }
        return url;
    }
}