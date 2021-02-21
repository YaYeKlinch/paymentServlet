package com.example.payment.dao.creditCard;

import com.example.payment.dao.Mapper;
import com.example.payment.dao.account.AccountMapper;
import com.example.payment.entity.Account;
import com.example.payment.entity.CardType;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class CardMapper  implements Mapper<CreditCard> {
    @Override
    public CreditCard extractFromResultSet(ResultSet rs) throws SQLException {
        AccountMapper accountMapper = new AccountMapper();
        CreditCard creditCard = new CreditCard();
        creditCard.setId(rs.getLong("credit_card.id"));
        creditCard.setNumber(rs.getLong("credit_card.number"));
        creditCard.setCvv(rs.getInt("credit_card.cvv"));
        creditCard.setPin(rs.getInt("credit_card.pin"));
        creditCard.setEndDate(rs.getDate("credit_card.end_date").toLocalDate());
        creditCard.setCardType(CardType.valueOf(rs.getString("credit_card.card_type")));
        creditCard.setAccount(accountMapper.extractFromResultSet(rs));
        return creditCard;
    }
}
