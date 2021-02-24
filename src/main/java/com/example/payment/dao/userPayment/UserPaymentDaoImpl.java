package com.example.payment.dao.userPayment;

import com.example.payment.dao.JDBCDao;
import com.example.payment.entity.UserPayment;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserPaymentDaoImpl  extends JDBCDao<UserPayment> implements UserPaymentDao {

    private static final String ALL_PAYMENTS_BY_USER = "SELECT * FROM user_makes_payment WHERE user_id=?";
    public UserPaymentDaoImpl(Connection connection) {
        super(connection,
                "INSERT INTO user_makes_payment(costs, time, user_id, payment_id, card_id) VALUES(?,?,?,?,?)",
                "SELECT * FROM user_makes_payment WHERE id = ?",
                "SELECT SQL_CALC_FOUND_ROWS * FROM user_makes_payment LIMIT ?,?",
                "SELECT * FROM user_makes_payment",
                "SELECT COUNT(*)FROM user_makes_payment",
                "COUNT(*)",
                "UPDATE user_makes_payment SET costs = ?, time = ?,user_id = ? , payment_id = ?, card_id = ? WHERE id = ?",
                6,
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

    @Override
    public List<UserPayment> findAllByUser(long userId) {
        List<UserPayment> userPayments = null;
        try (PreparedStatement statement = connection.prepareStatement(ALL_PAYMENTS_BY_USER)) {
            statement.setLong(1, userId);
            ResultSet result = statement.executeQuery();
            userPayments = getAllFromStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userPayments;
    }
}
