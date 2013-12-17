package com.company;

public class MeetDish extends KitchenDish {
    public MeetDish(String n, float p, float dis) {
        super(n, p, dis);
    }
    public MeetDish(String n, float p) {
        this(n, p, 0);
    }
}
