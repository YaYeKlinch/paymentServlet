package com.example.payment.service.account;

import com.example.payment.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccountsByUser(Long userId);
}
