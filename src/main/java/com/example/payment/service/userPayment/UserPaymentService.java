package com.example.payment.service.userPayment;

import com.example.payment.entity.CreditCard;
import com.example.payment.entity.Payment;
import com.example.payment.entity.User;
import com.example.payment.entity.UserPayment;
import com.example.payment.entity.dto.UserPaymentDto;

import java.util.List;

public interface UserPaymentService {
    List<UserPayment> getAllUserPaymentsByUser(Long userId);
    boolean createUserPayment(UserPaymentDto userPaymentDto , CreditCard card , Payment payment , User user);
}
