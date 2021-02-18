package com.example.payment.dao;

import com.example.payment.dao.account.AccountDao;
import com.example.payment.dao.account.AccountDaoImpl;
import com.example.payment.dao.user.UserDao;
import com.example.payment.dao.user.UserDaoImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(getConnection());
    }

    @Override
    public AccountDao createAccountDao() {
        return new AccountDaoImpl(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
