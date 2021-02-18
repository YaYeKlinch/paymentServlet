package com.example.payment.dao.account;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.User;

import java.util.List;

public interface AccountDao extends GenericDao<Account> {

    List<Account> findAllByUser(long userId);
}
