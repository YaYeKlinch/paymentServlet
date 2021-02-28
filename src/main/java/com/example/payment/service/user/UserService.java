package com.example.payment.service.user;

import com.example.payment.entity.User;
import com.example.payment.entity.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean registerUser(UserDto userDto);
    boolean checkRegistered(String username , String password);
    Optional<User> getUser(String email);
    List<User> findAllUsers();
    boolean changePermissionUser(User user);
    User findById(Long id);
}
