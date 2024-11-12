package com.delicious;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);

        boolean running = true;
        while (running) {
            ui.showMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Starting a new order...");
                    Order newOrder = new Order();
                    ui.showOrderMenu(newOrder);
                    break;
                case 0:
                    System.out.println("Exiting the application. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
