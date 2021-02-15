package com.example.payment.dao.functional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementAndEntityAction<E> {
    boolean execute(PreparedStatement statement, E entity) throws SQLException;
}