package com.example.payment.service.account;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.account.AccountDao;
import com.example.payment.dao.user.UserDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.AccountDto;
import com.example.payment.exception.EmailExistsException;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private static final int START_COSTS = 0;
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<Account> findAllAccountsByUser(Long userId) {
        try (AccountDao accountDao = daoFactory.createAccountDao()){
            return accountDao.findAllByUser(userId);
        }

    }
    @Override
    public boolean createAccount(AccountDto accountDto, User user) {
        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            if (isAccountExists(accountDto.getNumber(), user)) {
                throw new EmailExistsException("There is an account with that number address:" + accountDto.getNumber());
            }
            Account accountToCreate = new Account();
            accountToCreate.setUser(user);
            accountToCreate.setBlocked(false);
            accountToCreate.setCosts(START_COSTS);
            accountToCreate.setNumber(accountDto.getNumber());
            accountToCreate.setName(accountDto.getName());
            return accountDao.create(accountToCreate);
        }
    }

    @Override
    public boolean isAccountExists(String number , User user) {
        return false;
    }


}
