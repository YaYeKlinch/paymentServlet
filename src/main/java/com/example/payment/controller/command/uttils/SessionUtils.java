package com.example.payment.controller.command.uttils;

import com.example.payment.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static long getUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("LoggedUser");
        return user.getId();
    }
}
