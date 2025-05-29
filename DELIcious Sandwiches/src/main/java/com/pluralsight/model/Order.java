package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private List<Sandwich> sandwiches;
    private int drinkSize; // 0 - none, 1 - small, 2 - medium, 3 - large
    private boolean chips;
    private Date orderTime;

    public Order(List<Sandwich> sandwiches, Date orderTime, boolean chips, int drinkSize) {
        this.sandwiches = sandwiches;
        this.orderTime = orderTime;
        this.chips = chips;
        this.drinkSize = drinkSize;
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

    }
}
