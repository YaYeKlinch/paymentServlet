package com.example.payment.controller.command.impl.user_payment;

import com.example.payment.controller.command.Command;
import com.example.payment.entity.User;
import com.example.payment.entity.UserPayment;
import com.example.payment.service.userPayment.UserPaymentService;
import com.example.payment.service.userPayment.UserPaymentServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.example.payment.controller.command.uttils.SessionUtils.getUserId;

public class GetUserPaymentPage implements Command {
    UserPaymentService userPaymentService = new UserPaymentServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        User user = getUserId(request);
        List<UserPayment> userPayments = userPaymentService.getAllUserPaymentsByUser(user.getId());
        request.setAttribute("userPayments" , userPayments);
        return "userPayments.jsp";
    }
}
