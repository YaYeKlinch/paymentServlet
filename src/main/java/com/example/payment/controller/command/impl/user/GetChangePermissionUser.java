package com.example.payment.controller.command.impl.user;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.User;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class GetChangePermissionUser implements Command {

    private static final String URL = "/users.jsp";
    UserService userService = new UserServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        long user_id =  Long.parseLong(request.getParameter("user_id"));
        User user = userService.findById(user_id);
        userService.changePermissionUser(user);
        return URL;
    }


}
