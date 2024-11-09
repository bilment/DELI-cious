package com.delicious;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public void addSandwich() {}

    public void addDrink( ) {}

    public void addChips() {}

    public double calculateTotalPrice() {}

    public void saveReceipt() {}

    @Override
    public String toString() {}
}
