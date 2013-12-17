package com.company;

public class Alcohol extends BarDish {
    public Alcohol(String n, float p, float dis) {
        super(n, p, dis);
    }
    public Alcohol(String n, float p) {
        this(n, p, 0);
    }

}
