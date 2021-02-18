package com.example.payment.controller.command.impl;


import com.example.payment.controller.command.Command;
import com.example.payment.entity.Account;
import com.example.payment.service.account.AccountService;
import com.example.payment.service.account.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.example.payment.controller.command.uttils.SessionUtils.getUserId;


public class GetAccountsPage implements Command {
    private final AccountService accountService = new AccountServiceImpl();


    @Override
    public String execute(HttpServletRequest request) {
        long userId = getUserId(request);
        List<Account> accounts = accountService.findAllAccountsByUser(userId);
        request.setAttribute("accounts" , accounts);
        return "accounts.jsp";
    }
}
