package com.delicious;

public class Chips implements Product {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double calculatePrice(String size) {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips - Type: " + type;
    }
}
