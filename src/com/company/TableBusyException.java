package com.company;


public class TableBusyException extends RuntimeException {
    public TableBusyException(String message) {
        super(message);
    }
}
