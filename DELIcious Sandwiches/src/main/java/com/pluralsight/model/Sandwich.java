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

    private void calculateCost() {

    }

    private void buildSandwich() {

    }


    private double sandwichSize(int size) {

        double baseSandwichCost = 0;
        // switch case, may have to change to if
        switch (size) {
            case 4:
                baseSandwichCost = 5.50;
                break;
            case 8:
                 baseSandwichCost = 7.00;
                break;
            case 12:
                 baseSandwichCost = 8.50;
                break;
            default:
                System.out.println("Please enter a correct sandwich size.");
                break;
        }

        return baseSandwichCost;
    }

    private double sandwichSizeToppings(int size) {


    }
}
