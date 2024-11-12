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

    public void showOrderMenu() {}

    private void addSandwichToOrder() {}

    private void addDrinkToOrder() {}

    private void addChipsToOrder() {}

    private void checkoutOrder() {}
}
