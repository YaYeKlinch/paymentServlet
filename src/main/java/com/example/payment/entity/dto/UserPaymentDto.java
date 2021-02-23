package com.example.payment.entity.dto;

public class UserPaymentDto {
    private long number;
    private int costs;
    private int pin;


    public UserPaymentDto() {
    }
    public UserPaymentDto(long number, int costs, int pin) {
        this.number = number;
        this.costs = costs;
        this.pin = pin;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
