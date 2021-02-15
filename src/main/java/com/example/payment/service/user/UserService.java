package com.example.payment.service.user;

import com.example.payment.entity.dto.UserDto;

public interface UserService {
    boolean registerUser(UserDto userDto);
}
