package com.company;

public class Table {

    private int tableNumber;
    static int tableID=1;



    public int getTableNumber() {
        return tableNumber;
    }
    public Table (){
        tableNumber=tableID++;
    }


}
