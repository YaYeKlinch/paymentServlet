package com.example.payment.dao.Payment;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.Payment;

import java.util.Optional;

public interface PaymentDao extends GenericDao<Payment> {

    Optional<Payment> findByProperty(long property);
}
