package com.example.payment.service.account;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.account.AccountDao;
import com.example.payment.dao.user.UserDao;
import com.example.payment.entity.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<Account> findAllAccountsByUser(Long userId) {
        try (AccountDao accountDao = daoFactory.createAccountDao()){
            return accountDao.findAllByUser(userId);
        }

    }
}
