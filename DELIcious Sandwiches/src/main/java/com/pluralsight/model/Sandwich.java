package com.pluralsight.model;

import java.util.List;

public class Sandwich {

    private int size;
    private String breadType;
    private boolean isToasted;

    private List<Topping> toppings;




    private void calculateCost() {

    }

    private void buildSandwich() {

    }


    private double sandwichSize(int size) {

        double baseSandwichCost = 0;

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
