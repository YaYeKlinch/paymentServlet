package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.validators.AccountValidator;
import com.example.payment.entity.Account;
import com.example.payment.service.account.AccountService;
import com.example.payment.service.account.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostIncreasingCosts implements PostCommand {
    private static final String URL_ERROR = "/increaseCosts.jsp";
    private static final String URL_SUCCESS = "/accounts";
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        Integer costs = Integer.parseInt(request.getParameter("costs"));
        long accountId = Long.parseLong(request.getParameter("account_id"));
        if(tryIncreaseCosts(costs,request,accountId)){
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }
    private boolean tryIncreaseCosts(Integer costs , HttpServletRequest request , Long accountId){
        boolean increased = false;
        boolean isCorrect = AccountValidator.validateCosts(costs ,request);
        try {
            if(isCorrect){
                Account account = accountService.findAccountById(accountId);
                accountService.increaseCosts(account , costs);
                increased = true;
            }
        }catch(Exception ex){
            request.setAttribute("increaseException" , true);
        }
        return increased;
    }

    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }
}
