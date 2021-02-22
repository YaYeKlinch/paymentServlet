package com.example.payment.dao.Payment;

import com.example.payment.dao.Mapper;
import com.example.payment.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements Mapper<Payment> {
    @Override
    public Payment extractFromResultSet(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getLong("payment.id"));
        payment.setProperty(rs.getLong("payment.property"));
        payment.setPurpose(rs.getString("payment.purpose"));
        return payment;
    }

}
