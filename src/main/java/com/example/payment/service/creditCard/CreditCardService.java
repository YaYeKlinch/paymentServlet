package com.example.payment.service.creditCard;

import com.example.payment.entity.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> findAllCardsByAccount(Long accountId);
}
