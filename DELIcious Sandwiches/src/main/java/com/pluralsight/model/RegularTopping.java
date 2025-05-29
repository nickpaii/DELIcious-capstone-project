package com.pluralsight.model;

public class RegularTopping implements Topping {

    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public double getCost(int size) {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public String getToppingName() {
        return name;
    }

    @Override
    public String getType() {
        return "regular";
    }
}
