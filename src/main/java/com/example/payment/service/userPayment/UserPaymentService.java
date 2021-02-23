package com.example.payment.service.userPayment;

import com.example.payment.entity.UserPayment;

import java.util.List;

public interface UserPaymentService {
    List<UserPayment> getAllUserPaymentsByUser(Long userId);

}
