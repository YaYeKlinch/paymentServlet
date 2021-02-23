package com.example.payment.service.userPayment;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.dao.userPayment.UserPaymentDao;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.Payment;
import com.example.payment.entity.User;
import com.example.payment.entity.UserPayment;
import com.example.payment.entity.dto.UserPaymentDto;

import java.time.LocalDateTime;
import java.util.List;

public class UserPaymentServiceImpl implements UserPaymentService{

    DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<UserPayment> getAllUserPaymentsByUser(Long userId) {
        try (UserPaymentDao userPaymentDao = daoFactory.createUserPaymentDao()){
            return userPaymentDao.findAllByUser(userId);
        }
    }

    @Override
    public boolean createUserPayment(UserPaymentDto userPaymentDto, CreditCard card, Payment payment, User user) {
        try (UserPaymentDao userPaymentDao = daoFactory.createUserPaymentDao()){
            UserPayment userPayment = new UserPayment();
            if(card.getAccount().getCosts()< userPaymentDto.getCosts()){
                return false;
            }
            userPayment.setCosts(userPaymentDto.getCosts());
            userPayment.setUserId(user.getId());
            userPayment.setLocalDateTime(LocalDateTime.now());
            userPayment.setCreditCard(card);
            userPayment.setPayment(payment);
            return userPaymentDao.create(userPayment);
        }
    }
}
