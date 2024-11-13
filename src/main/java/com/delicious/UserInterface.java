package com.delicious;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        System.out.println("========================================");
        System.out.println("         WELCOME TO DELI-cious!         ");
        System.out.println("========================================");
        System.out.println("  Please select an option below:");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Your choice: ");
    }

    public void showOrderMenu(Order order) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("****************************************");
            System.out.println("*              ORDER MENU              *");
            System.out.println("****************************************");
            System.out.println("*  1) Add Sandwich                     *");
            System.out.println("*  2) Add Drink                        *");
            System.out.println("*  3) Add Chips                        *");
            System.out.println("*  4) Checkout                         *");
            System.out.println("*  0) Cancel Order                     *");
            System.out.println("****************************************");
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
        System.out.print("Choose sandwich size (4\"/8\"/12\"): ");
        String size = scanner.next();
        System.out.print("Choose bread type (White/Wheat/Rye/Wrap): ");
        String bread = scanner.next();
        System.out.print("Would you like it toasted? (Yes/No): ");
        boolean toasted = scanner.next().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Select meat toppings, type 'done' when finished:");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Available meats: -Steak, -Ham, -Salami, -Roast Beef, -Chicken, -Bacon");
        System.out.println("---------------------------------------------------------------------");
        while (true) {
            System.out.print("Your choice: ");
            String meatChoice = scanner.next();
            if (meatChoice.equalsIgnoreCase("done")) break;
            sandwich.addPremiumTopping(new Meat(meatChoice));
        }

        System.out.println("Select cheese toppings, type 'done' when finished:");
        System.out.println("----------------------------------------------------------");
        System.out.println("Available cheeses: -American, -Provolone, -Cheddar, -Swiss");
        System.out.println("----------------------------------------------------------");
        while (true) {
            System.out.print("Your choice: ");
            String cheeseChoice = scanner.next();
            if (cheeseChoice.equalsIgnoreCase("done")) break;
            sandwich.addPremiumTopping(new Cheese(cheeseChoice));
        }

        System.out.println("Add regular toppings, type 'done' to finish: ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Available regular toppings: -Lettuce, -Peppers, -Onions, -Tomatoes, -Jalapenos, -Cucumbers, -Pickles, -Guacamole, -Mushrooms");
        System.out.println("-------------------------------------------------------");
        while (true) {
            System.out.print("Your choice: ");
            String topping = scanner.next();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(new RegularTopping(topping));
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added: \n" + sandwich.toString());
    }

    private void addDrinkToOrder(Order order) {
        System.out.print("Choose drink size (Small/Medium/Large): ");
        String drinkSize = scanner.next();
        System.out.print("Choose flavor: ");
        String flavor = scanner.next();
        Drink drink = new Drink(drinkSize, flavor);
        order.addDrink(drink);
        System.out.println("Drink added: " + drink);
    }

    private void addChipsToOrder(Order order) {
        System.out.print("Choose chip type: ");
        String chipType = scanner.next();
        Chips chips = new Chips(chipType);
        order.addChips(chips);
        System.out.println("Chips added: " + chips);
    }

    private void checkoutOrder(Order order) {
        System.out.println("Checkout:");
        System.out.println(order);
        System.out.print("Confirm order? (yes/no): ");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("yes")) {
            order.saveReceipt();
            System.out.println("Order completed and receipt saved.");
        } else {
            System.out.println("Order canceled.");
        }
    }
}
