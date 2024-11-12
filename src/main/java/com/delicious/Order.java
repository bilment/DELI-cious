package com.delicious;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
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

    public void saveReceipt() {
        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()) {
            receiptsDir.mkdir();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String fileName = "receipts/" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("DELI-cious Order Receipt\n");
            writer.write("Order Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            for (Sandwich sandwich : sandwiches) {
                writer.write(sandwich.toString() + "\n");
            }
            for (Drink drink : drinks) {
                writer.write(drink.toString() + "\n");
            }
            for (Chips chip : chips) {
                writer.write(chip.toString() + "\n");
            }

            writer.write("\nTotal Price: $" + calculateTotalPrice() + "\n");
            System.out.println("Receipt saved successfully as " + fileName);
        } catch (Exception e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Details:\n");

        sb.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            sb.append(sandwich).append("\n");
        }

        sb.append("Drinks:\n");
        for (Drink drink : drinks) {
            sb.append(drink).append("\n");
        }

        sb.append("Chips:\n");
        for (Chips chip : chips) {
            sb.append(chip).append("\n");
        }

        return sb.toString();
    }
}
