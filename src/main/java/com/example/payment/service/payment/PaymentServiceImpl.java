package com.example.payment.service.payment;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.entity.Payment;

import java.util.List;

public class PaymentServiceImpl implements PaymentService{
    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Payment> findAllPayments() {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()){
            return paymentDao.findAll();
        }
    }

    @Override
    public Payment findById(long id) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()){
            return paymentDao.findById(id).orElseThrow(NullPointerException::new);
        }
    }

}
