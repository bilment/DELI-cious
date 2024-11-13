package com.delicious;

public class Meat extends Topping {

    public Meat(String name) {
        super(name);
    }

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "4":
                return 1.00;
            case "8":
                return 2.00;
            case "12":
                return 3.00;
            default:
                return 0.00;
        }
    }
}