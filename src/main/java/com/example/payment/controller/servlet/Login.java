package com.example.payment.controller.servlet;

import com.example.payment.service.user.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class Login extends HttpServlet {
    private UserService userService;
}
