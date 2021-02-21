package com.example.payment.entity.dto;

import com.example.payment.entity.CardType;

public class CardDto {
   private CardType cardType;
   private int pin;
   private int confirmPin;

    public CardDto(){

    }
    public CardDto(CardType cardType, int pin, int confirmPin) {
        this.cardType = cardType;
        this.pin = pin;
        this.confirmPin = confirmPin;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getConfirmPin() {
        return confirmPin;
    }

    public void setConfirmPin(int confirmPin) {
        this.confirmPin = confirmPin;
    }
}
