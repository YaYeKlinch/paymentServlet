package com.example.payment.dao.account;

import com.example.payment.dao.JDBCDao;
import com.example.payment.dao.Mapper;
import com.example.payment.dao.user.UserDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl  extends JDBCDao<Account> implements AccountDao {
    private final String FIND_ACCOUNTS_BY_USER_ID = "SELECT * FROM account " +
            "WHERE user.id=?";

    public AccountDaoImpl(Connection connection) {
        super(connection,
                "INSERT INTO account(name, number, costs, blocked, user_id) VALUES(?,?,?,?,?)",
                "SELECT * FROM account WHERE id = ?",
                "SELECT SQL_CALC_FOUND_ROWS * FROM account LIMIT ?,?",
                "SELECT * FROM account",
                "SELECT COUNT(*)FROM account",
                "COUNT(*)",
                "UPDATE account SET name = ?, number = ?, costs = ?, blocked = ?, user_id = ? WHERE id = ?",
                8,
                "DELETE FROM account WHERE id = ?",
                new AccountMapper());
    }

    @Override
    protected long getId(Account entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Account entity, long Id) throws SQLException {
        entity.setId(Id);
    }

    @Override
    protected void setEntityValues(PreparedStatement statement, Account entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getNumber());
        statement.setInt(3, entity.getCosts());
        statement.setBoolean(4, entity.isBlocked());
        statement.setLong(5, entity.getUser().getId());
    }

    @Override
    public List<Account> findAllByUser(long userId) {
        List<Account> accounts = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_ACCOUNTS_BY_USER_ID)) {
            statement.setLong(1, userId);
            accounts = getAllFromStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
}
