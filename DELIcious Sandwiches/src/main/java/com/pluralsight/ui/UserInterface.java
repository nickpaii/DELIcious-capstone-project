package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void display() {

    boolean running = true;

        while (running) {

        showHomeScreen();

        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                boolean orderScreenRunning = true;
                while(orderScreenRunning) {
                    showOrderScreen();

                    int orderChoice = scanner.nextInt();

                    switch (orderChoice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            System.out.println("Order successfully canceled.");
                            orderScreenRunning = false;
                            break;
                        default:
                            System.out.println("Please choose 1, 2, 3, 4 or 0.");
                            break;
                    }

                }
                break;
            case 0:
                System.out.println("Thank you for visiting DELIcious Sandwiches! Bye!!");
                running = false;
                break;
            default:
                System.out.println("Please enter 1 or 0. Thank you!");
                break;
        }
    }
        scanner.close();
}


    public void showHomeScreen() {
    System.out.println("====HOME SCREEN====");
    System.out.println("1) New Order");
    System.out.println("0) Exit");
    System.out.print("Enter your choice: ");
    }

    public void showOrderScreen() {
    System.out.println("====ORDER SCREEN====");
    System.out.println("1) Add Sandwich");
    System.out.println("2) Add Drink");
    System.out.println("3) Add Chips");
    System.out.println("4) Checkout");
    System.out.println("0) Cancel Order");
    System.out.print("Enter your choice: ");
    }
}
