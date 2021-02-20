package com.example.payment.dao.creditCard;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.CreditCard;

import java.util.List;

public interface CreditCardDao extends GenericDao<CreditCard> {

    List<CreditCard> findAllByAccount(Long accountId);
}
