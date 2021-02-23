package com.example.payment.dao.userPayment;

import com.example.payment.dao.Mapper;
import com.example.payment.dao.Payment.PaymentMapper;
import com.example.payment.dao.creditCard.CardMapper;
import com.example.payment.entity.UserPayment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPaymentMapper implements Mapper<UserPayment> {
    @Override
    public UserPayment extractFromResultSet(ResultSet rs) throws SQLException {
        UserPayment userPayment = new UserPayment();
        PaymentMapper paymentMapper = new PaymentMapper();
        CardMapper cardMapper = new CardMapper();
        userPayment.setId(rs.getLong("user_makes_payment.id"));
        userPayment.setCosts(rs.getInt("user_makes_payment.costs"));
        userPayment.setLocalDateTime(rs.getTimestamp("user_makes_payment.time").toLocalDateTime());
        userPayment.setUserId(rs.getInt("user_makes_payment.user_id"));
        userPayment.setPayment(paymentMapper.extractFromResultSet(rs));
        userPayment.setCreditCard(cardMapper.extractFromResultSet(rs));
        return userPayment;
    }
}
