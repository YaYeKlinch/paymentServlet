package com.example.payment.dao.functional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementAction {
    boolean execute(PreparedStatement statement) throws SQLException;
}