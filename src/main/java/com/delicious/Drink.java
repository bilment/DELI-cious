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
    public double calculatePrice(String size) {}

    @Override
    public String toString() {}
}

