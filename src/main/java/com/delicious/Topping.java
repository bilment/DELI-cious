package com.delicious;

public abstract class Topping implements Product {
    protected String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract double calculatePrice(String size);

    public String toString(String size) {
        return name + " - Price: $" + calculatePrice(size);
    }
}