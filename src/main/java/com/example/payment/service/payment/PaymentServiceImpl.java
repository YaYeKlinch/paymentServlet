package com.example.payment.service.payment;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.entity.Payment;
import com.example.payment.entity.dto.PaymentDto;
import com.example.payment.exception.AccountExistException;

import java.util.List;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService{
    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Payment> findAllPayments() {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()){
            return paymentDao.findAll();
        }
    }

    @Override
    public Optional<Payment> findById(long id) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()){
            return paymentDao.findById(id);
        }
    }

    @Override
    public boolean createPayment(PaymentDto paymentDto) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()){
            if(isPaymentExist(paymentDto.getProperty() , paymentDao)){
                throw new AccountExistException("There is an payment with that property address:" + paymentDto.getProperty());
            }
            Payment paymentToCreate = new Payment();
            paymentToCreate.setPurpose(paymentDto.getPurpose());
            paymentToCreate.setProperty(paymentDto.getProperty());
            return paymentDao.create(paymentToCreate);
        }
    }

    @Override
    public boolean isPaymentExist(long property , PaymentDao paymentDao) {
        return paymentDao.findByProperty(property).isPresent();
    }

}
