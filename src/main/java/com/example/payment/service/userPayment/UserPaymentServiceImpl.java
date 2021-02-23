package com.example.payment.service.userPayment;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.dao.userPayment.UserPaymentDao;
import com.example.payment.entity.UserPayment;

import java.util.List;

public class UserPaymentServiceImpl implements UserPaymentService{

    DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<UserPayment> getAllUserPaymentsByUser(Long userId) {
        try (UserPaymentDao userPaymentDao = daoFactory.createUserPaymentDao()){
            return userPaymentDao.findAllByUser(userId);
        }
    }
}
