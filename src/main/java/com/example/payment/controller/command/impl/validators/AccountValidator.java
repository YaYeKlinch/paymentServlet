package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.AccountDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class AccountValidator {
    private static final int LENGTH_OF_NUMBER = 8;
    private static final int MAX_COSTS = 100000;
    public static boolean validateAccountDto(AccountDto accountDto , HttpServletRequest request){
        ResourceBundle regex = ResourceBundle.getBundle("regexp");
        boolean isAccountEmpty = checkNotEmpty(accountDto.getName(),"accountNameEmpty",request);
        boolean isNumberEmpty = checkNotEmpty(accountDto.getNumber(),"numberEmpty",request);
        boolean isNumberCorrect =  checkNumberCorrect(accountDto.getNumber() , regex.getString("pattern.number"), request);
        return isAccountEmpty && isNumberEmpty && isNumberCorrect;
    }
    public static boolean validateCosts(Integer costs , HttpServletRequest request){
        if(costs<=0 || costs>MAX_COSTS){
            request.setAttribute("invalidCosts" , true);
            return false;
        }
        return true;
    }
    private static boolean  checkNotEmpty(String param, String emptyAttribute, ServletRequest request){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            return false;
        }
        return true;
    }
    private static boolean checkNumberCorrect(String number,String regex, ServletRequest request){
        if (!number.matches(regex) || number.length()!=LENGTH_OF_NUMBER) {
            request.setAttribute("numberWrong",true);
            return false;
        }
        return true;
    }

}
