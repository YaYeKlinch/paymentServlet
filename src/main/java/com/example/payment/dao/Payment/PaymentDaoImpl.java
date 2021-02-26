package com.example.payment.dao.Payment;

import com.example.payment.dao.JDBCDao;
import com.example.payment.dao.Mapper;
import com.example.payment.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PaymentDaoImpl extends JDBCDao<Payment> implements PaymentDao{
    private static final String FIND_BY_PURPOSE = "SELECT * FROM payment WHERE property=?";
    public PaymentDaoImpl(Connection connection) {
        super(connection,
                "INSERT INTO payment(property , purpose) VALUES(?,?)",
                "SELECT * FROM payment WHERE id = ?",
                "SELECT SQL_CALC_FOUND_ROWS * FROM payment LIMIT ?,?",
                "SELECT * FROM payment",
                "SELECT COUNT(*)FROM payment", "COUNT(*)",
                "UPDATE payment SET  property = ?, purpose = ? WHERE id = ?",
                3,
                "DELETE FROM payment WHERE id = ?",
                new PaymentMapper());
    }

    @Override
    protected long getId(Payment entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Payment entity, long Id) throws SQLException {
        entity.setId(Id);
    }

    @Override
    protected void setEntityValues(PreparedStatement statement, Payment entity) throws SQLException {
        statement.setLong(1, entity.getProperty());
        statement.setString(2,entity.getPurpose());
    }

    @Override
    public Optional<Payment> findByProperty(long property) {
        Payment payment = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_PURPOSE)) {
            statement.setLong(1, property);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                payment = extractEntity(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(payment);
    }
}
