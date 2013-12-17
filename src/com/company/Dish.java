package com.company;


public abstract class Dish {


    public Dish(String n, float p, float d){
        dishName=n;
        dishPrice=p;
        dishDiscount =d;
    }
    public float infoDish(){
        System.out.print("* "+dishName + " ");
        System.out.println("$"+dishPrice);
        if (dishDiscount !=0)
            System.out.println("           -"+ dishDiscount *100+"% discount - $"+dishPrice* dishDiscount);
        return (dishPrice*(1- dishDiscount));
    }
    public float infoDish(StringBuilder output){
        output.append("* " + dishName + " ");
        output.append("$" + dishPrice);
        output.append(System.getProperty("line.separator"));
        if (dishDiscount !=0){
            output.append("           -"+ dishDiscount *100+"% discount - $"+dishPrice* dishDiscount);
            output.append(System.getProperty("line.separator"));
        }
        return (dishPrice*(1- dishDiscount));
    }
    public boolean isBar() {
        return bar;
    }
    public void setBar(boolean bar) {
        this.bar = bar;
    }
    private String dishName;
    private float dishPrice;
    private boolean bar;
    private float dishDiscount;



}
