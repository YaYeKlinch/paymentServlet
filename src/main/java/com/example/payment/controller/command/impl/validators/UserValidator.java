package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.UserDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class UserValidator {
    public static void validateUser(HttpServletRequest request, UserDto dto , boolean allMatches) throws IOException {
        ResourceBundle regex = ResourceBundle.getBundle("regexp");
        //check fields filled
        checkNotEmpty(dto.getFirs_name(),"nameEmpty",request , allMatches);
        checkNotEmpty(dto.getLast_name(),"surnameEmpty",request, allMatches);
        checkNotEmpty(dto.getUsername(),"emailEmpty",request, allMatches);
        checkNotEmpty(dto.getPassword(),"passwordEmpty",request, allMatches);

        //check fields corresponds to regex
        if(allMatches) {
            matchesRegex(dto.getFirs_name(),regex.getString("pattern.name"),"nameWrong",request, allMatches);
            matchesRegex(dto.getLast_name(),regex.getString("pattern.name"),"surnameWrong",request, allMatches);
            matchesRegex(dto.getUsername(),regex.getString("pattern.email.regexp"),"emailWrong",request, allMatches);
            passwordMatching(dto.getPassword(),dto.getConfirmedPassword(),"passwordsNotEqual",request , allMatches);
        }
    }

    private static void  checkNotEmpty(String param, String emptyAttribute, ServletRequest request , boolean allMatches){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            allMatches = false;
        }
    }
    private  static void matchesRegex(String param, String regex ,String wrongRegexAttribute, ServletRequest request, boolean allMatches){
        if (!param.matches(regex)) {
            request.setAttribute(wrongRegexAttribute,true);
            allMatches = false;
        }
    }
    private  static void passwordMatching(String password, String confirm, String attribute, ServletRequest request, boolean allMatches){
        if(!password.equals(confirm)){
            request.setAttribute(attribute,true);
            allMatches = false;
        }
    }
}
