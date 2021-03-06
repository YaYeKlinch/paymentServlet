package com.example.payment.controller.servlet;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.impl.account.*;
import com.example.payment.controller.command.impl.user.*;
import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.credit_card.GetAddingCard;
import com.example.payment.controller.command.impl.credit_card.GetCardsPage;
import com.example.payment.controller.command.impl.credit_card.PostAddingCard;
import com.example.payment.controller.command.impl.payment.GetAddingPayment;
import com.example.payment.controller.command.impl.payment.GetHomePage;
import com.example.payment.controller.command.impl.payment.PostAddingPayment;
import com.example.payment.controller.command.impl.user_payment.GetMakingPayment;
import com.example.payment.controller.command.impl.user_payment.GetUserPaymentPage;
import com.example.payment.controller.command.impl.user_payment.PostMakingPayment;

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
        urlToGetCommand.put("/" , new GetHomePage());
        urlToGetCommand.put("/logout" , new GetLogout());
        urlToGetCommand.put("/user-payment" , new GetUserPaymentPage());
        urlToGetCommand.put("/make-payment" , new GetMakingPayment());
        urlToGetCommand.put("/add-payment" , new GetAddingPayment());
        urlToGetCommand.put("/users" , new GetUsersPage());
        urlToGetCommand.put("/users/change-permission" , new GetChangePermissionUser());

        urlToPostCommand.put("/registration" , new PostRegister());
        urlToPostCommand.put("/login-page" , new PostLogin());
        urlToPostCommand.put("/logout" , new PostLogin());
        urlToPostCommand.put("/accounts/add-account" , new PostAddingAccount());
        urlToPostCommand.put("/accounts/cards/add-card" , new PostAddingCard());
        urlToPostCommand.put("/accounts/increase-costs" , new PostIncreasingCosts());
        urlToPostCommand.put("/make-payment" , new PostMakingPayment());
        urlToPostCommand.put("/add-payment" , new PostAddingPayment());

    }
}
