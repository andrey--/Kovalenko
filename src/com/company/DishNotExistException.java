package com.company;

public class DishNotExistException extends RuntimeException {
    private StringBuilder message = new StringBuilder();
    public DishNotExistException(Dish dish) {
        super();
        dish.infoDish(message);

    }
    public void dishNotExistMessage(){
        System.out.println("Dish "+message+" does not exist!");
    }
}
