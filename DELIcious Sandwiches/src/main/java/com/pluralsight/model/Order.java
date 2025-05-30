package com.pluralsight.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private List<Sandwich> sandwiches;
    private int drinkSize; // 0 - none, 1 - small, 2 - medium, 3 - large
    private boolean chips;
    private Date orderTime;

    public Order() {
        this.sandwiches = new ArrayList<Sandwich>();
        this.orderTime = new Date();
        this.chips = chips;
        this.drinkSize = 0;
    }

    public void addSandwich (Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void setChips(boolean chips) {
        this.chips = chips;
    }

    public void setDrinkSize(int size) {
        this.drinkSize = size;
    }

    public double calculateCost() {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculateCost();
        }

        if (drinkSize == 1) total += 2.00;
        else if (drinkSize == 2) total += 2.50;
        else if (drinkSize == 3) total += 3.00;

        if (chips) total += 1.50;

        return total;
    }

    public String printReceipt() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sb.append("Order Time: ").append(date.format(orderTime)).append("\n\n");

        int count = 1;
        for (Sandwich sandwich : sandwiches) {
            sb.append("Sandwich ").append(count++).append(": ")
              .append(sandwich.getSize()).append("\" ").append(sandwich.getBreadType())
                    .append(sandwich.isToasted() ? " (Toasted)\n" : "\n");

            for (int i = 0; i < sandwich.getToppings().size(); i++) {
                sb.append("  - ").append(sandwich.getToppings().get(i).getToppingName());
                if (sandwich.getToppings().get(i).isExtra()) sb.append(" (extra)");
                sb.append("\n");
            }
        }

        if (drinkSize > 0) {
            sb.append("\nDrink: ");
            if (drinkSize == 1) sb.append("Small");
            else if (drinkSize == 2) sb.append("Medium");
            else if (drinkSize == 3) sb.append("Large");
            sb.append("\n");
        }

        if (chips) sb.append("Chips: Yes\n");

        sb.append("\nTotal Cost: $").append(String.format("%.2f", calculateCost())).append("\n");

        return sb.toString();
    }

    public String getFileName() {
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd-hhmmss");
        return date.format(orderTime) + ".txt";
    }

    public void saveReceipt(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
           directory.mkdirs();
        }

        File file = new File(directoryPath, getFileName());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(printReceipt());
        } catch (IOException e) {
            System.out.println("Error: Could not save receipt: " + e.getMessage());
        }
    }
}
