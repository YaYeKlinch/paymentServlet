package com.example.payment.controller.servlet;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.*;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

public class AbstractServlet extends HttpServlet {
    protected Map<String, Command> urlToGetCommand = new HashMap<>();
    protected Map<String, PostCommand> urlToPostCommand=  new HashMap<>();

    @Override
    public void init() {
        urlToGetCommand.put("/registration" , new GetRegister());
        urlToGetCommand.put("/login-page" , new GetLogin());
        urlToGetCommand.put("/accounts" , new GetAccountsPage());
        urlToGetCommand.put("/accounts/add-account" , new GetAddingAccount());
        urlToGetCommand.put("/accounts/cards" , new GetCardsPage());
        urlToGetCommand.put("/accounts/cards/add-card" , new GetAddingCard());
        urlToGetCommand.put("/accounts/increase-costs" , new GetIncreasingCosts());

        urlToPostCommand.put("/registration" , new PostRegister());
        urlToPostCommand.put("/login-page" , new PostLogin());
        urlToPostCommand.put("/accounts/add-account" , new PostAddingAccount());
        urlToPostCommand.put("/accounts/cards/add-card" , new PostAddingCard());
        urlToPostCommand.put("/accounts/increase-costs" , new PostIncreasingCosts());
    }
}
