package com.example.payment.service.payment;

import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.entity.Payment;
import com.example.payment.entity.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    List<Payment> findAllPayments();
    Payment findById(long id);
    boolean createPayment(PaymentDto paymentDto);
    boolean isPaymentExist(long property, PaymentDao paymentDao);
}
