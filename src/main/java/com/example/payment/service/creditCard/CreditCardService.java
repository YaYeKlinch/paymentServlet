package com.example.payment.service.creditCard;

import com.example.payment.entity.Account;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    List<CreditCard> findAllCardsByAccount(Long accountId);
    boolean createCard(Account account, CardDto cardDto);
    Optional<CreditCard> findByNumber(long number);
}
