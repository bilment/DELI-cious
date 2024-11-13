package com.delicious;

public class BLT extends Sandwich {

    public BLT() {
        super("8", "White", true);

        this.addPremiumTopping(new Meat("Bacon"));
        this.addPremiumTopping(new Cheese("Cheddar"));
        this.addRegularTopping(new RegularTopping("Lettuce"));
        this.addRegularTopping(new RegularTopping("Tomato"));
        this.addRegularTopping(new RegularTopping("Ranch"));
    }
}