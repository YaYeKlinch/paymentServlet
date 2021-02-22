package com.example.payment.dao;


import com.example.payment.dao.Payment.PaymentDao;
import com.example.payment.dao.account.AccountDao;
import com.example.payment.dao.creditCard.CreditCardDao;
import com.example.payment.dao.user.UserDao;
import com.example.payment.entity.Account;

public abstract class DaoFactory {
    private static volatile DaoFactory daoFactory;

    public abstract PaymentDao createPaymentDao();
    public abstract CreditCardDao createCreditCardDao();
    public abstract UserDao createUserDao();
    public abstract AccountDao createAccountDao();
    public static synchronized DaoFactory getInstance(){
        if( daoFactory == null){
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
