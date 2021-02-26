package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.CardDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class CardValidator {
    private static final int LENGTH_OF_PIN = 4;
    public static boolean validateCard(CardDto cardDto , HttpServletRequest request){
       boolean isPinEmpty =  checkNotEmpty(cardDto.getPin(),"pinEmpty",request);
       boolean isConfirmPinEmpty =  checkNotEmpty(cardDto.getConfirmPin(),"confirmPinEmpty",request);
       boolean isPinCorrect = checkPinCorrect(cardDto.getPin() ,request);
       boolean isPinMatching = checkPinMatching(cardDto.getPin(), cardDto.getConfirmPin(), request);
       return isPinCorrect && isConfirmPinEmpty && isPinEmpty && isPinMatching;
    }
    private static boolean  checkNotEmpty(Integer param, String emptyAttribute, ServletRequest request ){
        if(param == null){
            request.setAttribute(emptyAttribute,true);
            return false;
        }
        return  true;
    }
    private static boolean checkPinCorrect(int pin , ServletRequest request ){
        if(String.valueOf(pin).length() != LENGTH_OF_PIN){
            request.setAttribute("pinIncorrect",true);
            return false;
        }
        return true;
    }
    private static boolean checkPinMatching(int pin ,int confirmPin ,  ServletRequest request){
        if(pin!=confirmPin){
            request.setAttribute("pinNotMatching",true);
            return false;
        }
        return true;
    }
}
