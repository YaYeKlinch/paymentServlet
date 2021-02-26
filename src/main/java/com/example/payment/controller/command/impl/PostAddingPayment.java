package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.validators.PaymentValidator;
import com.example.payment.entity.dto.PaymentDto;
import com.example.payment.exception.AccountExistException;
import com.example.payment.service.payment.PaymentService;
import com.example.payment.service.payment.PaymentServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PostAddingPayment implements PostCommand {
    boolean allMatches;
    PaymentService paymentService = new PaymentServiceImpl();
    private static final String URL_ERROR = "/addPayment.jsp";
    private static final String URL_SUCCESS = "/";

    @Override
    public String execute(HttpServletRequest request) {
        allMatches = true;
        PaymentDto paymentDto = validateDto(request);
        if (createAndAddErrorAttributes(paymentDto, request)) {
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }

    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }

    private boolean createAndAddErrorAttributes(PaymentDto paymentDto, HttpServletRequest request) {
        boolean registered = false;
        if (allMatches) {
            try {
                registered = tryCreateOrAddCreationErrorAttr(paymentDto, request);
            } catch (AccountExistException ex) {
                request.setAttribute("PaymentExists", true);
            }

        }
        return registered;
    }

    private boolean tryCreateOrAddCreationErrorAttr(PaymentDto paymentDto, HttpServletRequest request) {
        if (paymentService.createPayment(paymentDto)) {
            return true;
        } else {
            request.setAttribute("creationError", true);
            return false;
        }
    }

    private PaymentDto validateDto(HttpServletRequest request) {
        PaymentDto paymentDto = null;
        try {
            paymentDto = new PaymentDto(Long.parseLong(request.getParameter("property")),
                    request.getParameter("purpose"));
            allMatches = PaymentValidator.validatePayment(paymentDto, request);
        } catch (IllegalArgumentException ex) {
            allMatches = false;
        }
        return paymentDto;
    }
}
