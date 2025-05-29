package com.pluralsight.model;


public class PremiumTopping implements Topping {

    private String name;
    private String toppingType;
    private boolean extraToppings;

    public PremiumTopping(String name, String toppingType, boolean extraToppings) {
        this.name = name;
        this.toppingType = toppingType;
        this.extraToppings = extraToppings;
    }

    @Override
    public double getCost(int size) {
        double baseCost = 0.0;
        double extraCost = 0.0;

        if (toppingType.equalsIgnoreCase("meat")) {
            if (size == 4) baseCost = 1.00;
            else if (size == 8) baseCost = 2.00;
            else if (size == 12) baseCost = 3.00;

            if (extraToppings) {
                if (size == 4) extraCost = .50;
                else if (size == 8) extraCost = 1.00;
                else if (size == 12) extraCost = 1.50;
            }
        }
        else if (toppingType.equalsIgnoreCase("cheese")) {
            if (size == 4) baseCost = .75;
            else if (size == 8) baseCost = 1.50;
            else if (size == 12) baseCost = 2.25;

            if (extraToppings) {
                if (size == 4) extraCost = .30;
                else if (size == 8) extraCost = .60;
                else if (size == 12) extraCost = .90;
            }
        }

        return baseCost + extraCost;
    }

    @Override
    public boolean isExtra() {
        return extraToppings;
    }

    @Override
    public String getToppingName() {
        return name;
    }

    @Override
    public String getType() {
        return toppingType;
    }
}
