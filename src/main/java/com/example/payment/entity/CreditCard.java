package com.example.payment.entity;

import java.time.LocalDate;

public class CreditCard {
    private long id;
    private long number;
    private int cvv;
    private LocalDate endDate;
    private int pin;
    private  Account account;
    private CardType cardType;

    public CreditCard(){

    }

    public CreditCard(long id) {
        this.id = id;
    }

    public CreditCard(long number, int cvv, LocalDate endDate, int pin, Account account, CardType cardType) {
        this.number = number;
        this.cvv = cvv;
        this.endDate = endDate;
        this.pin = pin;
        this.account = account;
        this.cardType = cardType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
