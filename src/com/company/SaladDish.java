package com.company;

public class SaladDish extends KitchenDish {
    public SaladDish(String n, float p) {
        this(n, p, 0);
    }
    public SaladDish(String n, float p, float dis) {
        super(n, p, dis);
    }
}
