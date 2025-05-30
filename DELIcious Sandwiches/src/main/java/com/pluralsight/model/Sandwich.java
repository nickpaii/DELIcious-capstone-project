package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private int size;
    private String breadType;
    private boolean isToasted;

    private List<Topping> toppings;

    public Sandwich(int size, boolean isToasted, String breadType) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.toppings = new ArrayList<Topping>();
    }

    public double calculateCost() {

        double baseCost = 0.0;
        if (size == 4) baseCost = 5.50;
        else if (size == 8) baseCost = 7.00;
        else if (size == 12) baseCost = 8.50;

        for (Topping topping : toppings) {
            baseCost += topping.getCost(size);
        }
        return baseCost;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
   }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }
}
