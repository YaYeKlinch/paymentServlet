package com.example.payment.dao.user;

import com.example.payment.dao.Mapper;
import com.example.payment.entity.Role;
import com.example.payment.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("user.id"));
        user.setFirs_name(rs.getString("user.firs_name"));
        user.setLast_name(rs.getString("user.last_name"));
        user.setUsername(rs.getString("user.username"));
        user.setPassword(rs.getString("user.password"));
        user.setRole(Role.valueOf(rs.getString("user.role")));
        user.setActive(rs.getBoolean("user.active"));
        return user;
    }
}
