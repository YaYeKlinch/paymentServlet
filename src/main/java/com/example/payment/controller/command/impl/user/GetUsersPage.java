package com.example.payment.controller.command.impl.user;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.User;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.example.payment.controller.command.uttils.SessionUtils.getUserId;

public class GetUsersPage implements Command {
    UserService userService = new UserServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        User user = getUserId(request);
        List<User> users = userService.findAllUsers();
        users.remove(user);
        request.setAttribute("users" , users);
        return "users.jsp";
    }
}
