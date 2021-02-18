package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.AccountDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class AccountValidator {
    private static final int LENGTH_OF_NUMBER = 8;
    public static void validateAccountDto(AccountDto accountDto , HttpServletRequest request, boolean allMatches){
        ResourceBundle regex = ResourceBundle.getBundle("regexp");

        checkNotEmpty(accountDto.getName(),"nameEmpty",request , allMatches);
        checkNotEmpty(accountDto.getNumber(),"numberEmpty",request, allMatches);

        if(allMatches){
            checkNumberCorrect(accountDto.getNumber() , regex.getString("pattern.number"), request , allMatches);
        }
    }
    private static void  checkNotEmpty(String param, String emptyAttribute, ServletRequest request , boolean allMatches){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            allMatches = false;
        }
    }
    private static void checkNumberCorrect(String number,String regex, ServletRequest request , boolean allMatches){
        if (!number.matches(regex) || number.length()!=LENGTH_OF_NUMBER) {
            request.setAttribute("number is wrong",true);
            allMatches = false;
        }
    }
}
