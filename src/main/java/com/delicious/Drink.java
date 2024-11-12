package com.delicious;

public class Drink implements Product {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {}

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {}
}

