package com.example.payment.dao.userPayment;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.UserPayment;

import java.util.List;

public interface UserPaymentDao extends GenericDao<UserPayment> {

    List<UserPayment> findAllByUser(long userId);
}
