package com.delicious;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice(sandwich.getSize());
        }
        for (Drink drink : drinks) {
            total += drink.calculatePrice(drink.getSize());
        }
        for (Chips chip : chips) {
            total += chip.calculatePrice("");
        }
        return total;
    }

    public void saveReceipt() {}

    @Override
    public String toString() {}
}
