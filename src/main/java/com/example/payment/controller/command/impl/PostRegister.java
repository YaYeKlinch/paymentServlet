package com.example.payment.controller.command.impl;

import com.example.payment.controller.command.Command;
import com.example.payment.controller.command.PostCommand;
import com.example.payment.controller.command.impl.validators.UserValidator;
import com.example.payment.entity.dto.UserDto;
import com.example.payment.exception.EmailExistsException;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PostRegister implements PostCommand {

    private final UserService userService = new UserServiceImpl();
    private boolean allMatches;
    private static final String URL_ERROR = "/register.jsp";
    private static final String URL_SUCCESS = "/login.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        allMatches = true;
        UserDto user = getValidatedDto(request);
        boolean registered = registerAndAddErrorAttributes(user,request);
        if(registered){
            request.setAttribute("values",user);
            return URL_SUCCESS;
        }
        return URL_ERROR;
    }
    private boolean registerAndAddErrorAttributes(UserDto user, HttpServletRequest request){
        boolean registered = false;
        if(allMatches){
            try{
                registered = tryRegisterOrAddRegistrationErrorAttr(user,request);
            }catch (EmailExistsException ex){
                request.setAttribute("emailExists",true);
            }
        }
        return registered;
    }
    private boolean tryRegisterOrAddRegistrationErrorAttr(UserDto user, HttpServletRequest request){
        if(userService.registerUser(user)){
            return true;
        }else{
            request.setAttribute("registrationError",true);
            return false;
        }
    }
    private UserDto getValidatedDto(HttpServletRequest request) {
        UserDto user = null;
        try {
            user = new UserDto(
                    request.getParameter("firs_name"),
                    request.getParameter("last_name"),
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("confirmedPassword"));

            UserValidator.validateUser(request, user , allMatches);

        } catch (IllegalArgumentException|IOException ex) {
            allMatches = false;
        }
        return user;
    }

    @Override
    public  boolean isError(String url){
        return url.equals(URL_ERROR);
    }
}
