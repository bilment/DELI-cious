package com.delicious;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        System.out.println("=== Welcome to DELI-cious! === Please select an option below:");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Your choice: ");
    }

    public void showOrderMenu(Order order) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("Order Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSandwichToOrder(order);
                    break;
                case 2:
                    addDrinkToOrder(order);
                    break;
                case 3:
                    addChipsToOrder(order);
                    break;
                case 4:
                    checkoutOrder(order);
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSandwichToOrder(Order order) {
        System.out.print("Choose sandwich size (4/8/12): ");
        String size = scanner.next();
        System.out.print("Choose bread type (white/wheat/rye/wrap): ");
        String bread = scanner.next();
        System.out.print("Would you like it toasted? (yes/no): ");
        boolean toasted = scanner.next().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.print("Add premium toppings (meat/cheese), type 'done' to finish: ");
        while (true) {
            String toppingType = scanner.next();
            if (toppingType.equalsIgnoreCase("done")) break;
            if (toppingType.equalsIgnoreCase("meat")) {
                sandwich.addPremiumTopping(new Meat("Steak"));
            } else if (toppingType.equalsIgnoreCase("cheese")) {
                sandwich.addPremiumTopping(new Cheese("Cheddar"));
            }
        }

        System.out.print("Add regular toppings (lettuce/onions/tomatoes etc.), type 'done' to finish: ");
        while (true) {
            String topping = scanner.next();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(new RegularTopping(topping));
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added: " + sandwich);
    }

    private void addDrinkToOrder() {}

    private void addChipsToOrder() {}

    private void checkoutOrder() {}
}
