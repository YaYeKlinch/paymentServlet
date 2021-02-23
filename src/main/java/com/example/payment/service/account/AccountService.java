package com.example.payment.service.account;

import com.example.payment.entity.Account;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccountsByUser(Long userId);
    boolean createAccount(AccountDto accountDto , User user);
    Account findAccountById(Long id);
    void increaseCosts(Account account , int costs);
    void spendMoney(Account account , int costs);
}
