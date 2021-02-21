package com.example.payment.controller.command.impl.validators;

import com.example.payment.entity.dto.CardDto;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class CardValidator {
    private static final int LENGTH_OF_PIN = 4;
    public static void validateCard(CardDto cardDto , HttpServletRequest request, boolean allMatches){
        checkNotEmpty(cardDto.getPin(),"pinEmpty",request, allMatches);
        checkNotEmpty(cardDto.getConfirmPin(),"confirmPinEmpty",request, allMatches);
        if(allMatches){
            checkPinCorrect(cardDto.getPin() ,request , allMatches);
            checkPinMatching(cardDto.getPin(), cardDto.getConfirmPin(), request , allMatches);
        }
    }
    private static void  checkNotEmpty(Integer param, String emptyAttribute, ServletRequest request , boolean allMatches){
        if(param == null){
            request.setAttribute(emptyAttribute,true);
            allMatches = false;
        }
    }
    private static void checkPinCorrect(int pin , ServletRequest request , boolean allMatches){
        if(String.valueOf(pin).length() != LENGTH_OF_PIN){
            request.setAttribute("pinIncorrect",true);
            allMatches = false;
        }
    }
    private static void checkPinMatching(int pin ,int confirmPin ,  ServletRequest request , boolean allMatches){
        if(pin!=confirmPin){
            request.setAttribute("pinNotMatching",true);
            allMatches = false;
        }
    }
}
