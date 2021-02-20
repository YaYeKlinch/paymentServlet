package com.example.payment.dao.creditCard;

import com.example.payment.dao.JDBCDao;
import com.example.payment.dao.Mapper;
import com.example.payment.dao.user.UserDao;
import com.example.payment.dao.user.UserMapper;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditCardDaoImpl extends JDBCDao<CreditCard> implements CreditCardDao {



    public CreditCardDaoImpl(Connection connection) {
        super(connection,
                "INSERT INTO credit_card(number, cvv, end_date, pin, account_id,card_type) VALUES(?,?,?,?,?,?)",
                "SELECT * FROM credit_card WHERE id = ?",
                "SELECT SQL_CALC_FOUND_ROWS * FROM credit_card LIMIT ?,?",
                "SELECT * FROM credit_card",
                "SELECT COUNT(*)FROM credit_card",
                "COUNT(*)",
                "UPDATE credit_card SET number = ?, cvv = ?, end_date = ?, pin = ?, account_id = ?, card_type = ? WHERE id = ?",
                8,
                "DELETE FROM credit_card WHERE id = ?",
                new CardMapper());
    }

    @Override
    protected long getId(CreditCard entity) {
        return entity.getId();
    }

    @Override
    protected void setId(CreditCard entity, long Id) throws SQLException {
        entity.setId(Id);
    }

    @Override
    protected void setEntityValues(PreparedStatement statement, CreditCard entity) throws SQLException {
        statement.setLong(1, entity.getNumber());
        statement.setInt(2, entity.getCvv());
        statement.setDate(3, Date.valueOf(entity.getEndDate()));
        statement.setInt(4, entity.getPin());
        statement.setLong(5, entity.getAccount().getId());
        statement.setString(6, entity.getCardType().name());
    }


}
