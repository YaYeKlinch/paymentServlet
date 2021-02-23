package com.example.payment.service.payment;

import com.example.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAllPayments();
    Payment findById(long id);
}
