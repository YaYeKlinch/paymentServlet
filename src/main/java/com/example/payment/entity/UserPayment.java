package com.example.payment.entity;

import java.time.LocalDateTime;

public class UserPayment {
    private long id;
    private int costs;
    private LocalDateTime localDateTime;
    private long userId;
    private CreditCard creditCard;
    private Payment payment;

    public UserPayment(){

    }

    public UserPayment(long id) {
        this.id = id;
    }

    public UserPayment(long id, int costs, LocalDateTime localDateTime, long userId, CreditCard creditCard, Payment payment) {
        this.id = id;
        this.costs = costs;
        this.localDateTime = localDateTime;
        this.userId = userId;
        this.creditCard = creditCard;
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
