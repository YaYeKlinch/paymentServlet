package com.example.payment.service.account;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.account.AccountDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.AccountDto;
import com.example.payment.exception.AccountExistException;

import java.util.List;
import java.util.Optional;

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
            if (isAccountExists(accountDto.getNumber(), user ,accountDao)) {
                throw new AccountExistException("There is an account with that number address:" + accountDto.getNumber());
            }
            Account accountToCreate = new Account();
            accountToCreate.setUser(user.getId());
            accountToCreate.setBlocked(false);
            accountToCreate.setCosts(START_COSTS);
            accountToCreate.setNumber(accountDto.getNumber());
            accountToCreate.setName(accountDto.getName());
            return accountDao.create(accountToCreate);
        }
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        try (AccountDao accountDao = daoFactory.createAccountDao()){
            return accountDao.findById(id);
        }
    }

    @Override
    public void increaseCosts(Account account, int costs) {
        try (AccountDao accountDao = daoFactory.createAccountDao()){
            account.setCosts(account.getCosts()+costs);
            accountDao.update(account);
        }
    }

    @Override
    public void spendMoney(Account account, int costs) {
        try (AccountDao accountDao = daoFactory.createAccountDao()){
            account.setCosts(account.getCosts()-costs);
            accountDao.update(account);
        }
    }

    private boolean isAccountExists(String number , User user , AccountDao accountDao) {
        return accountDao.findByNumber(number, user.getId()).isPresent();
    }


}
