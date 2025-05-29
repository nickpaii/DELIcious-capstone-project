package com.pluralsight.model;

public abstract interface Topping {


    double getCost(int size);

    void isExtra();

    void getToppingName();
}
