package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.CardDto;
import com.example.payment.entity.dto.PaymentDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class PaymentValidator {
    private static final int LENGTH_OF_PROPERTY = 8;
    public static boolean validatePayment(PaymentDto paymentDto, HttpServletRequest request){
        ResourceBundle regex = ResourceBundle.getBundle("regexp");

       boolean isPurposeEmpty  = checkNotEmpty(paymentDto.getPurpose(),"purposeEmpty",request );
       boolean isNumberCorrect =   checkNumberCorrect(paymentDto.getPurpose() , regex.getString("pattern.number"), request);
        return isNumberCorrect && isPurposeEmpty;
    }
    private static boolean  checkNotEmpty(String param, String emptyAttribute, ServletRequest request){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            return false;
        }
        return true;
    }
    private static boolean checkNumberCorrect(String number, String regex, ServletRequest request ){
        if (!number.matches(regex) || number.length()!=LENGTH_OF_PROPERTY) {
            request.setAttribute("propertyWrong",true);
            return false;
        }
        return true;
    }
}
