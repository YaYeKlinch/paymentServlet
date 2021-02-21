package com.example.payment.dao.creditCard;

import com.example.payment.dao.JDBCDao;
import com.example.payment.dao.Mapper;
import com.example.payment.dao.user.UserDao;
import com.example.payment.dao.user.UserMapper;
import com.example.payment.entity.Account;
import com.example.payment.entity.CardType;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CreditCardDaoImpl extends JDBCDao<CreditCard> implements CreditCardDao {

    private static final String FIND_CARDS_BY_ACCOUNT = "SELECT * " +
            "FROM credit_card LEFT JOIN account ON credit_card.account_id = account.id" +
            " WHERE credit_card.account_id =?";
    private static final String FIND_CARD_BY_TYPE = "SELECT * " +
            "FROM credit_card LEFT JOIN account ON credit_card.account_id = account.id" +
            " WHERE card_type = ? AND credit_card.account_id = ?";
    private static final String FIND_MAX_NUMBER = "SELECT MAX(credit_card.number) AS maxNumber FROM credit_card";
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


    @Override
    public List<CreditCard> findAllByAccount(Long accountId) {
        List<CreditCard> cards = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_CARDS_BY_ACCOUNT)) {
            statement.setLong(1, accountId);
            cards = getAllFromStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cards;
    }

    @Override
    public Optional<CreditCard> findByTypeCard(CardType cardType, Long accountId) {
        CreditCard card = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_CARD_BY_TYPE)) {
            statement.setString(1, cardType.name());
            statement.setLong(2, accountId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                card = extractEntity(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(card);
    }

    @Override
    public Optional<Long> findMaxNumber() {
        Long number = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_MAX_NUMBER)) {
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                number = result.getLong("maxNumber");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(number);
    }
}
