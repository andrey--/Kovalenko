package com.company;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private static int orderID=1;

    private List<Dish> orderForTable;
    private int orderNumber;
    public Order(){
        orderForTable = new ArrayList<Dish>();
        orderNumber=orderID++;
    }
    public void addDish(Dish dish){
        orderForTable.add(dish);
    }

    public void printOrder(){
        float totalPrice=0;
        System.out.println("###Order -  "+orderNumber+" ###");
        System.out.println("**Kitchen**");
        for (Dish d:this.orderForTable){
            if (!d.isBar())
            totalPrice+=d.infoDish();
        }
        System.out.println("**Bar**");
        for (Dish d:this.orderForTable){
            if (d.isBar())
                totalPrice+=d.infoDish();
        }
        System.out.println("### Total: $"+totalPrice);
    }

    public void printOrder(StringBuilder output){
        float totalPrice=0;
        output.append("###Order -  "+orderNumber+" ###");
        output.append(System.getProperty("line.separator"));
        output.append("**Kitchen**");
        output.append(System.getProperty("line.separator"));
        for (Dish d:this.orderForTable){
            if (!d.isBar())
                totalPrice+=d.infoDish(output);
        }
        output.append("**Bar**");
        output.append(System.getProperty("line.separator"));
        for (Dish d:this.orderForTable){
            if (d.isBar())
                totalPrice+=d.infoDish(output);
        }
        output.append("### Total: $"+totalPrice);
        output.append(System.getProperty("line.separator"));

    }
    public void makeOrder(ArrayList<Dish> dishes){
        //Dish f=new Alcohol("Vodka11_fake", 10, 0);
        StringBuilder message=new StringBuilder();
            for (Dish d:dishes){
                try {
                if (dishes.indexOf(d)==-1){
                    d.infoDish(message);
                    throw new DishNotExistException(d);
                    }
                addDish(d);
                }
                catch (DishNotExistException e) {
                    e.dishNotExistMessage();

                }
            }
        System.out.println("Order done.");
    }




}
