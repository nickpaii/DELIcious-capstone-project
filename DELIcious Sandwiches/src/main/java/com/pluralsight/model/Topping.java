package com.pluralsight.model;

public abstract interface Topping {


    double getCost(int size);

    boolean isExtra();

    String getToppingName();

    String getType();
}
