package com.pluralsight.ui;

import com.pluralsight.model.*;

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
                startNewOrder();
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
    System.out.println("====WELCOME TO DELIcious SANDWICHES!====");
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

    private void startNewOrder() {
        Order order = new Order();
        boolean running = true;
        while(running) {
            showOrderScreen();
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    addSandwich(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addChips(order);
                    break;
                case 4:
                    checkout(order);
                    running = false;
                    break;
                case 0:
                    System.out.println("Order was canceled successfully.\n");
                    running = false;
                    break;
                default:
                    System.out.println("Please choose 1, 2, 3, 4, or 0. Thank you.\n");
            }
        }
    }

    private void addSandwich(Order order) {
        System.out.print("What size sandwich would you like? (4 / 8 / 12): ");
        int size = scanner.nextInt();

        System.out.print("Choose your bread type (white / wheat / rye / wrap): ");
        String breadType = scanner.next().toLowerCase();

        System.out.print("Would you like your sandwich toasted? (Y/N): ");
        boolean toasted = scanner.next().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, breadType, toasted);
        addToppings(sandwich);
        order.addSandwich(sandwich);
        System.out.println("Sandwich added!\n");
    }

    private void addToppings(Sandwich sandwich) {
        boolean running = true;
        while (running) {
            System.out.print("Add a topping? (Y/N): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                running = false;
                continue;
            }

            System.out.print("Select topping category (1 = meat, 2 = cheese, 3 = regular): ");
            int toppingType = scanner.nextInt();
            scanner.nextLine();
            if (toppingType == 1 || toppingType == 2) {
                String type = "";
                if (toppingType == 1) {
                    System.out.println("Which meat topping would you like? We have: Steak, Ham, Salami, Roast Beef, Chicken, and Bacon!");
                    type = "meat";
                }
                else if (toppingType == 2) {
                    System.out.println("What kind of cheese would you like? We have: American, Provolone, Cheddar and Swiss!");
                    type = "cheese";
                }

                System.out.print("Choose your " + type + " topping: ");
                String name = scanner.nextLine().toLowerCase();

                System.out.print("Would you like extra " + name + "? (Y/N): ");
                String extraInput = scanner.next();
                boolean extra = false;
                if (extraInput.equalsIgnoreCase("y")) {
                    extra = true;
                }

                Topping topping = new PremiumTopping(name, type, extra);
                sandwich.addTopping(topping);
            }
            else if (toppingType == 3) {
                System.out.println("Which regular toppings would you like? We have: Lettuce, Peppers, " +
                        "Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, and Mushrooms!");
                System.out.print("Choose your toppings: ");
                String name = scanner.next();
                Topping topping = new RegularTopping(name.toLowerCase());
                sandwich.addTopping(topping);
            }
            else {
                System.out.println("Oops! That options doesn't exist, please try again!");
            }
        }
    }

    private void addDrink(Order order) {
        System.out.print("Select drink size (1 = Small ($2.00), 2 = Medium ($2.50), 3 = Large ($3.00), 0 = None): ");
        int size = scanner.nextInt();
        order.setDrinkSize(size);
        if (size > 0) {
            System.out.println("Drink added!\n");
        }
    }

    private void addChips(Order order) {
        System.out.print("Add chips for $1.50? (Y/N): ");
        String chipsInput = scanner.next();
        boolean chips = false;
        if (chipsInput.equalsIgnoreCase("y")){
            chips = true;
        }
        order.setChips(chips);
        if (chips) {
            System.out.println("Chips added!\n");
        }
    }

    private void checkout(Order order) {
        System.out.println("\n====ORDER SUMMARY====");
        System.out.println(order.printReceipt());
        System.out.print("Save receipt? (Y/N): ");
        String saveInput = scanner.next();
        if (saveInput.equalsIgnoreCase("y")) {
            order.saveReceipt("receipts");
            System.out.println("Receipt saved!\n");
        }
    }
}
