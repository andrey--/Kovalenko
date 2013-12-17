package com.company;


import java.util.Random;
import java.util.Scanner;

public class Cafe {
    private HeadWaiter boss=new HeadWaiter();


    private Scanner scan = new Scanner(System.in);
    public void start (){
        int input;
        int tableNumber;
        do {
            System.out.println("1 - get number of free tables");
            System.out.println("2 - order table");
            System.out.println("3 - get statistic");
            System.out.println("0 - exit");
            System.out.println("Select");
            input=scan.nextInt();
            try {
                switch (input){
                    case 1:
                        System.out.println("Number of free tables "+boss.getFreeTablesNumber());
                        break;
                    case 2:
                        System.out.println("Input table#");
                        tableNumber=scan.nextInt();
                        boss.orderTable(tableNumber, "C:\\Order.txt");
                        break;
                    case 3:
                        boss.getStatistic();
                        boss.getStatistic("C:\\Statistic.txt");
                        break;

                }
            } catch (TableOutOfRangerException e) {
                System.out.println(e.getMessage());
            } catch (TableBusyException e) {
                System.out.println(e.getMessage());
            }


        }   while (input!=0);
    }
}
