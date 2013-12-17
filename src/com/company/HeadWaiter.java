package com.company;


import java.io.IOException;
import java.util.*;

public class HeadWaiter {
    private Map<Integer, Waiter> orderedTables ;
    private final int totalTableNumbers=10;
    private Random rand = new Random();
    ArrayList<Dish> dishes=new ArrayList<Dish>();
    private Map<Integer, Order> orderForTable;
    private Waiter[] waiters=new Waiter[3];
    public HeadWaiter() {
        waiters[0]=new Waiter("Adam Smith");
        waiters[1]=new Waiter("Bob Marley");
        waiters[2]=new Waiter("Chris Clark");
        float alcoholDiscount = 0.1f;
        dishes.add(new Alcohol("Vodka", 10, alcoholDiscount));
        dishes.add(new MeetDish("Fuagra", 120));
        dishes.add(new SaladDish("Cesar", 120));
        dishes.add(new NonAlcohol("Sprite", 1));
        float desertDiscount = 0.05f;
        dishes.add(new DesertsDish("N'yamka", 20, desertDiscount));
        orderedTables = new HashMap<Integer,Waiter>();
        orderForTable = new HashMap<Integer, Order>();

    }
    public int getFreeTablesNumber(){
        return (totalTableNumbers-orderedTables.size());
    }
    public void orderTable (int tableNumber, String fileName) throws TableOutOfRangerException, TableBusyException{

        if ((tableNumber<1)||(tableNumber>totalTableNumbers)){
            throw new TableOutOfRangerException("Bad table's number");

        }
        if (orderedTables.containsKey(tableNumber)){
           throw new TableBusyException("Table #"+tableNumber+" is busy");


        }
        else{
            orderedTables.put(tableNumber, waiters[rand.nextInt(3)]);
            System.out.println("Table# #" + tableNumber + " is reserved. Your waiter is " + orderedTables.get(tableNumber).getWaiterName());
            Order order =new Order();
            StringBuilder output=new StringBuilder();
            order.makeOrder(dishes);
            order.printOrder(output);
            try{
                FileTransactions.write(fileName, output);
            }
            catch (IOException e){
                System.out.println("Something goes wrong while writing to file!");
            }
            orderForTable.put(tableNumber, order);

        }
    }
    public void orderTable (int tableNumber) throws TableOutOfRangerException, TableBusyException{

        if ((tableNumber<1)||(tableNumber>totalTableNumbers)){
            throw new TableOutOfRangerException("Bad table's number");

        }
        if (orderedTables.containsKey(tableNumber)){
            throw new TableBusyException("Table #"+tableNumber+" is busy");


        }
        else{
            orderedTables.put(tableNumber, waiters[rand.nextInt(3)]);
            System.out.println("Table# #" + tableNumber + " is reserved. Order was done. Your waiter is " + orderedTables.get(tableNumber).getWaiterName());
            Order order =new Order();
            order.makeOrder(dishes);
            order.printOrder();
            orderForTable.put(tableNumber, order);

        }
    }
    public void getStatistic(){
        for (int i=1; i<=totalTableNumbers;i++){
            if (orderedTables.containsKey(i)){
                System.out.println("Table number: "+i+", table status: busy, waiter's name:"+orderedTables.get(i).getWaiterName());
                orderForTable.get(i).printOrder();
            }
            else
                System.out.println("Table number: " + i + ", table status: free ");
        }
    }
    public void getStatistic(String fileName){
        StringBuilder output=new StringBuilder();
        for (int i=1; i<=totalTableNumbers;i++){
            if (orderedTables.containsKey(i)){
                output.append("Table number: " + i + ", table status: busy, waiter's name:" + orderedTables.get(i).getWaiterName());
                output.append(System.getProperty("line.separator"));
                orderForTable.get(i).printOrder(output);
            }
            else{
                output.append("Table number: " + i + ", table status: free ");
                output.append(System.getProperty("line.separator"));

            }
        }
        try{
            FileTransactions.write(fileName, output);
        }
        catch (IOException e){
            System.out.println("Something goes wrong while writing to file!");
        }
    }

}
