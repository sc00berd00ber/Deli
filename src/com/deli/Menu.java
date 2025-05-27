package com.deli;

import com.deli.Items.Chips;
import com.deli.Items.Drink;
import com.deli.Items.Sandwich;
import com.deli.Toppings.Cheese;
import com.deli.Toppings.Meat;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Veggie;

import java.util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public void homeScreen() {
        while (true) {
            System.out.println("\n-----------------Home Screen-----------------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("\nChoice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    currentOrder = new Order();
                    orderScreen();
                }
                case "0" -> {
                    System.out.println("Goodbye! See you soon!");
                    return;
                }
                default -> System.out.println("Invalid Entry! Try Again");
            }
        }
    }

    public void orderScreen() {
        while (true) {
            System.out.println("\n-----------------Order Screen-----------------");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("\nChoice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid Entry! Try Again");
            }
        }
    }

    public void addSandwich() {
        System.out.print("Select Bread Type (White, Wheat, Rye, Wrap): ");
        String breadChoice = scanner.nextLine();

        System.out.print("Sandwich Size (4, 8, 12): ");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.print("Would you like it toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        Sandwich sandwich = new Sandwich(breadChoice, size, toasted);

        toppingsMenu(sandwich);

        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added!");
    }

    public void toppingsMenu(Sandwich sandwich) {
        System.out.println("\n-----------------Toppings Menu-----------------");

        // --- Meats ---
        String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        System.out.println("\nMeat Options:\n");
        for (int i = 0; i < meats.length; i++) {
            System.out.printf("%d) %s%n", i + 1, meats[i]);
        }
        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] meatChoices = scanner.nextLine().split(",");
        for (String choice : meatChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < meats.length) {
                    String meat = meats[index];
                    System.out.printf("Add extra %s? (Y/N): ", meat);
                    boolean extra = scanner.nextLine().equalsIgnoreCase("Y");
                    sandwich.addTopping(new Meat(meat, extra));
                }
            } catch (NumberFormatException ignored) {}
        }

        // --- Cheeses ---
        String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"};
        System.out.println("\nCheese Options:\n");
        for (int i = 0; i < cheeses.length; i++) {
            System.out.printf("%d) %s%n", i + 1, cheeses[i]);
        }
        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] cheeseChoices = scanner.nextLine().split(",");
        for (String choice : cheeseChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < cheeses.length) {
                    String cheese = cheeses[index];
                    System.out.printf("Add extra %s cheese? (Y/N): ", cheese);
                    boolean extra = scanner.nextLine().equalsIgnoreCase("Y");
                    sandwich.addTopping(new Cheese(cheese, extra));
                }
            } catch (NumberFormatException ignored) {}
        }

        // --- Veggie com.deli.Toppings ---
        String[] veggies = {
                "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
                "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
        };
        System.out.println("\nRegular Topping Options:");
        for (int i = 0; i < veggies.length; i++) {
            System.out.printf("%d) %s%n", i + 1, veggies[i]);
        }
        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] toppingChoices = scanner.nextLine().split(",");
        Set<Integer> selectedRegularIndexes = new HashSet<>();

        for (String choice : toppingChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < veggies.length && selectedRegularIndexes.add(index)) {
                    System.out.printf("Add extra %s? (Y/N): ", veggies[index]);
                    boolean extra = scanner.nextLine().equalsIgnoreCase("Y");
                    sandwich.addTopping(new Veggie(veggies[index], extra));
                }
            } catch (NumberFormatException ignored) {}
        }

        // --- Sauces ---
        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
        System.out.println("\nSauce Options:");
        for (int i = 0; i < sauces.length; i++) {
            System.out.printf("%d) %s%n", i + 1, sauces[i]);
        }
        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] sauceChoices = scanner.nextLine().split(",");
        for (String choice : sauceChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < sauces.length) {
                    sandwich.addSauce(new Sauce(sauces[index]));
                }
            } catch (NumberFormatException ignored) {}
        }

        System.out.println("\nToppings added!");
    }


    public void addDrink() {
        System.out.println("\n-----------------Drinks Menu-----------------");
        System.out.println("1) Coca-cola\n2) Pepsi\n3) Root Beer\n4) Fanta\n5) Sprite");
        System.out.print("Select Drink Flavor: ");
        String flavor = scanner.nextLine();

        System.out.print("Select Drink Size (S, M, L): ");
        String size = scanner.nextLine();

        currentOrder.addDrink(new Drink(size, flavor));
        System.out.println("Drink added!");
    }

    public void addChips() {
        System.out.println("\n-----------------Chips Menu-----------------");
        System.out.println("1) Lays - BBQ\n2) Hot Cheetos\n3) Ruffles - Original\n4) Pringles - Salt & Vinegar");
        System.out.print("Select Chips: ");
        String type = scanner.nextLine();

        currentOrder.addChips(new Chips(type));
        System.out.println("Chips added!");
    }

    public void checkout() {
        System.out.println("\n---------- Order Summary ----------");
        System.out.println(currentOrder.generateReceipt());
        System.out.printf("Total: $%.2f%n", currentOrder.calculateTotal());

        System.out.print("\n1) Confirm\n2) Cancel\nChoice: ");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            ReceiptService.saveReceipt(currentOrder);
            System.out.println("Order confirmed and receipt saved.");
        } else {
            System.out.println("Order canceled.");
        }
    }
}
