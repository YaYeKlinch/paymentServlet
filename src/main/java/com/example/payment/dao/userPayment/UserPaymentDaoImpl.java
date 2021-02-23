package com.example.payment.dao.userPayment;

import com.example.payment.dao.JDBCDao;
import com.example.payment.entity.UserPayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserPaymentDaoImpl  extends JDBCDao<UserPayment> implements UserPaymentDao {

    public UserPaymentDaoImpl(Connection connection) {
        super(connection,
                "INSERT INTO user_makes_payment(costs, time, user_id, payment_id, card_id) VALUES(?,?,?,?,?)",
                "SELECT * FROM user_makes_payment WHERE id = ?",
                "SELECT SQL_CALC_FOUND_ROWS * FROM user_makes_payment LIMIT ?,?",
                "SELECT * FROM user_makes_payment",
                "SELECT COUNT(*)FROM user_makes_payment",
                "COUNT(*)",
                "UPDATE user_makes_payment SET costs = ?, time = ?,user_id = ? , payment_id = ?, card_id = ? WHERE id = ?",
                8,
                "DELETE FROM user_makes_payment WHERE id = ?",
                new UserPaymentMapper());
    }

    @Override
    protected long getId(UserPayment entity) {
        return entity.getId();
    }

    @Override
    protected void setId(UserPayment entity, long Id) throws SQLException {
        entity.setId(Id);
    }

    @Override
    protected void setEntityValues(PreparedStatement statement, UserPayment entity) throws SQLException {
        statement.setInt(1 ,entity.getCosts());
        statement.setTimestamp(2 , Timestamp.valueOf(entity.getLocalDateTime()));
        statement.setLong(3 ,entity.getUserId());
        statement.setLong(4,entity.getPayment().getId());
        statement.setLong(5 , entity.getCreditCard().getId());
    }
}
