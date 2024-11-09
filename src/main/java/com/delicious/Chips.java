package com.delicious;

public class Chips implements Product {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double calculatePrice(String size) {}

    @Override
    public String toString() {}
}
