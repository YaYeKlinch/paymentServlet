package com.example.payment.entity;

public class Payment {
    private long id;
    private long property;
    private String purpose;

    public Payment(){

    }
    public Payment(long id) {
        this.id = id;
    }

    public Payment(long id, long property, String purpose) {
        this.id = id;
        this.property = property;
        this.purpose = purpose;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
