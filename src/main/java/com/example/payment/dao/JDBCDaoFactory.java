package com.example.payment.dao;

import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.dao.Payment.PaymentDaoImpl;
import com.example.payment.dao.account.AccountDao;
import com.example.payment.dao.account.AccountDaoImpl;
import com.example.payment.dao.creditCard.CreditCardDao;
import com.example.payment.dao.creditCard.CreditCardDaoImpl;
import com.example.payment.dao.user.UserDao;
import com.example.payment.dao.user.UserDaoImpl;
import com.example.payment.dao.userPayment.UserPaymentDao;
import com.example.payment.dao.userPayment.UserPaymentDaoImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionHolder.getDataSource();


    @Override
    public UserPaymentDao createUserPaymentDao() {
        return new UserPaymentDaoImpl(getConnection());
    }

    @Override
    public PaymentDao createPaymentDao() {
        return new PaymentDaoImpl(getConnection());
    }

    @Override
    public CreditCardDao createCreditCardDao() {
        return new CreditCardDaoImpl(getConnection());
    }

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
