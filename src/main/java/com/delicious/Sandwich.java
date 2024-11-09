package com.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public void addPremiumTopping(Topping topping) {}

    public void addRegularTopping(Topping topping) {}

    public String getSize() {}

    @Override
    public double calculatePrice(String size) {}

    @Override
    public String toString() {}
}

