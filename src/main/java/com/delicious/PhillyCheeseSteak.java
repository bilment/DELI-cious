package com.delicious;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak() {
        super("8", "White", true);

        this.addPremiumTopping(new Meat("Steak"));
        this.addPremiumTopping(new Cheese("American"));
        this.addRegularTopping(new RegularTopping("Peppers"));
        this.addRegularTopping(new RegularTopping("Mayo"));
    }
}