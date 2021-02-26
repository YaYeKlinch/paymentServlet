package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.CardDto;
import com.example.payment.entity.dto.PaymentDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class PaymentValidator {
    private static final int LENGTH_OF_PROPERTY = 8;
    public static void validatePayment(PaymentDto paymentDto, HttpServletRequest request, boolean allMatches){
        ResourceBundle regex = ResourceBundle.getBundle("regexp");

        checkNotEmpty(paymentDto.getPurpose(),"purposeEmpty",request , allMatches);
        if(allMatches){
            checkNumberCorrect(paymentDto.getPurpose() , regex.getString("pattern.number"), request , allMatches);
        }
    }
    private static void  checkNotEmpty(String param, String emptyAttribute, ServletRequest request , boolean allMatches){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            allMatches = false;
        }
    }
    private static void checkNumberCorrect(String number, String regex, ServletRequest request , boolean allMatches){
        if (!number.matches(regex) || number.length()!=LENGTH_OF_PROPERTY) {
            request.setAttribute("propertyWrong",true);
            allMatches = false;
        }
    }
}