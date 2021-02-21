package com.example.payment.service.creditCard;

import com.example.payment.dao.creditCard.CreditCardDao;
import com.example.payment.entity.CreditCard;

import java.util.Optional;

public class CardGenerator {
    private static final int CVV_LENGTH = 3;
    private static final Long START_CARD = 1000000000000000L;

    public static int generateRandomCvv(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<CVV_LENGTH; i++){
            int x = (int) (Math.random()*10);
            sb.append(x);
        }
        return Integer.getInteger(sb.toString()) ;
    }
    public static Long generateRandomNumber(CreditCardDao cardDao){
        Optional<Long> maxNumberCard = cardDao.findMaxNumber();
        return maxNumberCard.map(number -> number + 1L).orElse(START_CARD);
    }
}
