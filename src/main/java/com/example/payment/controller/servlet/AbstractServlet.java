package com.example.payment.controller.servlet;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.impl.GetRegister;
import com.example.payment.controller.command.impl.PostRegister;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

public class AbstractServlet extends HttpServlet {
    protected Map<String, Command> urlToGetCommand = new HashMap<>();
    protected Map<String, Command> urlToPostCommand=  new HashMap<>();

    @Override
    public void init() {
        urlToGetCommand.put("/registration" , new GetRegister());
        urlToPostCommand.put("/registration" , new PostRegister());
    }
}
