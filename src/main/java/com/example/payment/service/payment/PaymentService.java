package com.example.payment.service.payment;

import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.entity.Payment;
import com.example.payment.entity.dto.PaymentDto;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAllPayments();
    Optional<Payment> findById(long id);
    boolean createPayment(PaymentDto paymentDto);
    boolean isPaymentExist(long property, PaymentDao paymentDao);
}
