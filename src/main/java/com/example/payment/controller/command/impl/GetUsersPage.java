package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.User;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersPage implements Command {
    UserService userService = new UserServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = userService.findAllUsers();
        request.setAttribute("users" , users);
        return "users.jsp";
    }
}
