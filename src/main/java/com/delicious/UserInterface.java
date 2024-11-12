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

    private void addSandwichToOrder() {}

    private void addDrinkToOrder() {}

    private void addChipsToOrder() {}

    private void checkoutOrder() {}
}
