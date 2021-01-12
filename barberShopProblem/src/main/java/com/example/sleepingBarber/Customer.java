package com.example.sleepingBarber;

import lombok.Data;

import java.util.Date;

@Data
public class Customer implements Runnable
{
    private String name;
    private Date inTime;
    private Bshop shop;

    public Customer(Bshop shop) {
        this.shop = shop;
    }

    public void run() {
        goForHairCut();
    }
    private synchronized void goForHairCut() {
        shop.add(this);
    }
}