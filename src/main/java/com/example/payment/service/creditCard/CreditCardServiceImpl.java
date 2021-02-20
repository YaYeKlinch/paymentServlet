package com.example.payment.service.creditCard;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.creditCard.CreditCardDao;
import com.example.payment.entity.CreditCard;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService{


    private final DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<CreditCard> findAllCardsByAccount(Long accountId) {
        try (CreditCardDao cardDao = daoFactory.createCreditCardDao()){
            return cardDao.findAllByAccount(accountId);
        }
    }
}
