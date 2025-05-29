package com.pluralsight.model;

public interface Topping {


    double getCost(int size);

    boolean isExtra();

    String getToppingName();

    String getType();
}
