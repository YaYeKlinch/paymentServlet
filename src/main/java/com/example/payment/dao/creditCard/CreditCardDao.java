package com.example.payment.dao.creditCard;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.CardType;
import com.example.payment.entity.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardDao extends GenericDao<CreditCard> {

    List<CreditCard> findAllByAccount(Long accountId);

    Optional<CreditCard> findByTypeCard(CardType cardType, Long accountId);
    Optional<CreditCard> findByNumber(long number);
    Optional<Long> findMaxNumber();
}
