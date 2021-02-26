package com.example.payment.entity.dto;

public class PaymentDto {
    private long property;
    private String purpose;

    public PaymentDto() {
    }

    public PaymentDto(long property, String purpose) {
        this.property = property;
        this.purpose = purpose;
    }

    public long getProperty() {
        return property;
    }

    public void setProperty(long property) {
        this.property = property;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
