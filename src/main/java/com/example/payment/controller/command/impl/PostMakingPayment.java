package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.PostCommand;
import com.example.payment.entity.dto.UserPaymentDto;
import com.example.payment.service.userPayment.UserPaymentService;
import com.example.payment.service.userPayment.UserPaymentServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostMakingPayment implements PostCommand {
    UserPaymentService userPaymentService = new UserPaymentServiceImpl();
    private static final String URL_ERROR = "makePayment.jsp";
    private static final String URL_SUCCESS = "/";
    boolean allMatches;
    @Override
    public String execute(HttpServletRequest request) {
        long paymentId = Long.parseLong(request.getParameter("payment_id"));
        return null;
    }
    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }
    private UserPaymentDto validateDto(HttpServletRequest request){
       UserPaymentDto userPaymentDto = null;
        try {
            userPaymentDto = new UserPaymentDto(
                    Long.parseLong(request.getParameter("number")),
                    Integer.parseInt(request.getParameter("costs")),
                    Integer.parseInt(request.getParameter("pin")));
        }catch (IllegalArgumentException ex){

        }
        return null;
    }

}
