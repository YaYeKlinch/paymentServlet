package com.example.payment.dao.account;

import com.example.payment.dao.Mapper;
import com.example.payment.dao.user.UserMapper;
import com.example.payment.entity.Account;
import com.example.payment.entity.Role;
import com.example.payment.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements Mapper<Account> {
    @Override
    public Account extractFromResultSet(ResultSet rs) throws SQLException {
        UserMapper userMapper = new UserMapper();
        Account account = new Account();
        account.setId(rs.getLong("account.id"));
        account.setName(rs.getString("account.name"));
        account.setNumber(rs.getString("account.number"));
        account.setCosts(rs.getInt("account.costs"));
        account.setBlocked(rs.getBoolean("account.blocked"));
        account.setUser(rs.getLong("account.uid"));
        return account;
    }
}
