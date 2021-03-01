package com.example.payment.service.account;

import com.example.payment.entity.Account;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.AccountDto;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAllAccountsByUser(Long userId);
    boolean createAccount(AccountDto accountDto , User user);
    Optional<Account> findAccountById(Long id);
    void increaseCosts(Account account , int costs);
    void spendMoney(Account account , int costs);
}
