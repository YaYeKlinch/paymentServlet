package com.example.payment.service.user;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.user.UserDao;
import com.example.payment.dao.user.UserDaoImpl;
import com.example.payment.entity.Role;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.UserDto;
import com.example.payment.exception.EmailExistsException;

public class UserServiceImpl implements UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public boolean registerUser(UserDto userDto) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            if (emailExists(userDto.getUsername(),userDao)) {
                throw new EmailExistsException("There is an account with that email address:" + userDto.getUsername());
            }
            User userToCreate = new User();
            userToCreate.setFirs_name(userDto.getFirs_name());
            userToCreate.setLast_name(userDto.getLast_name());
            userToCreate.setUsername(userDto.getUsername());
            userToCreate.setPassword(userDto.getPassword());
            userToCreate.setRole(Role.USER);
            userToCreate.setActive(true);
            return userDao.create(userToCreate);
        }
    }
    private boolean emailExists(String email, UserDao userDao) {
        return userDao.findByUsername(email).isPresent();
    }
}
