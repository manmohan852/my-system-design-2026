package com.manmohan.systemdesign.parkingLot.model;

public class User {

    private String name;
    private boolean vip;

    public User(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }

    public String getName() {
        return name;
    }
}