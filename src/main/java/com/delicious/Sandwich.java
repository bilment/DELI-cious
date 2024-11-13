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

    public String getSize() {
        return size;
    }

    public void addPremiumTopping(Topping premiumTopping) {
        toppings.add(premiumTopping);
    }

    public void addRegularTopping(Topping regularTopping) {
        toppings.add(regularTopping);
    }

    @Override
    public double calculatePrice(String size) {
        double price = 0;

        switch (size) {
            case "4":
                price += 5.50;
                break;
            case "8":
                price += 7.00;
                break;
            case "12":
                price += 8.50;
                break;
        }

        for (Topping topping : toppings) {
            price += topping.calculatePrice(this.size);
        }

        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sandwich - Size: ").append(size).append("\", Bread: ").append(breadType)
                .append(", Toasted: ").append(toasted ? "Yes" : "No").append("\nToppings:\n");

        for (Topping topping : toppings) {
            sb.append(" - ").append(topping.toString(this.size)).append("\n");
        }

        sb.append("Total Sandwich Price: $").append(calculatePrice(this.size));

        return sb.toString();
    }
}
