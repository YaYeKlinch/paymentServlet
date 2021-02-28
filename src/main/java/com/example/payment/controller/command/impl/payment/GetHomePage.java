package com.example.payment.controller.command.impl.payment;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.Payment;
import com.example.payment.service.payment.PaymentService;
import com.example.payment.service.payment.PaymentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetHomePage implements Command {
    PaymentService paymentService = new PaymentServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        List<Payment> payments = paymentService.findAllPayments();
        request.setAttribute("payments" , payments);
        return "home.jsp";
    }
}
