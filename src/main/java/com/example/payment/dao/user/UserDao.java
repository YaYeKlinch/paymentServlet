package com.example.payment.dao.user;

import com.example.payment.dao.GenericDao;
import com.example.payment.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByUsername(String username);
}
