package com.example.payment.entity;

public class Account {
    private long id;
    private String name;
    private String number;
    private int costs;
    private boolean blocked;
    private long user_id;

    public Account(){

    }
    public Account(long id){
        this.id = id;
    }
    public Account(long id, String name, String number, int costs, boolean blocked) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.costs = costs;
        this.blocked = blocked;
    }
    public Account(long id, String name, String number, int costs, boolean blocked, long user_id) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.costs = costs;
        this.blocked = blocked;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public long getUser() {
        return user_id;
    }

    public void setUser(long user) {
        this.user_id = user;
    }
}
