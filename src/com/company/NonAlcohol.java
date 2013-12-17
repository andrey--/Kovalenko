package com.company;

public class NonAlcohol extends BarDish {
    public NonAlcohol(String n, float p) {
        this(n, p, 0);
    }
    public NonAlcohol(String n, float p, float dis) {
        super(n, p, dis);
    }
}
