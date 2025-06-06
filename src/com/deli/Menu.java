package com.deli;

import com.deli.Items.Chips;
import com.deli.Items.Drink;
import com.deli.Items.sandwiches.*;
import com.deli.Items.Side;
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
            System.out.println("=========================================");
            System.out.println("🍽️      -------- Home --------         🍽️");
            System.out.println("=========================================");
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
            System.out.println("2) Add Signature Sandwich");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Add Sides");
            System.out.println("6) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("\nChoice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1" -> addSandwich();
                case "2" -> addSignatureSandwich();
                case "3" -> addDrink();
                case "4" -> addChips();
                case "5" -> addSide();
                case "6" -> checkout();
                case "0" -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid Entry! Try Again");
            }
        }
    }

    public void addSandwich() {
        String[] breadOptions = {"White", "Wheat", "Rye", "Wrap"};

        // --- Bread Selection ---
        System.out.println("\n-----------------Bread Options-----------------");
        for (int i = 0; i < breadOptions.length; i++) {
            System.out.printf("%d) %s%n", i + 1, breadOptions[i]);
        }

        String breadType;
        while (true) {
            System.out.print("\nChoose your bread (1-4): ");
            try {
                int breadChoice = Integer.parseInt(scanner.nextLine());
                if (breadChoice >= 1 && breadChoice <= breadOptions.length) {
                    breadType = breadOptions[breadChoice - 1];
                    break;
                } else {
                    System.out.println("Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // --- Size Selection ---
        int size;
        while (true) {
            System.out.println("\nSelect Sandwich Size:");
            System.out.println("4\" - $5.50");
            System.out.println("8\" - $7.00");
            System.out.println("12\" - $8.50");
            System.out.println("\nChoose Size (4, 8, or 12): ");
            try {
                int sizeChoice = Integer.parseInt(scanner.nextLine());
                if (sizeChoice == 4 || sizeChoice == 8 || sizeChoice == 12) {
                    size = sizeChoice;
                    break;
                } else {
                    System.out.println("Please enter 4, 8, or 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // --- Toasted? ---
        boolean toasted;
        while (true) {
            System.out.print("Would you like the sandwich toasted? (Y/N): ");
            String toastChoice = scanner.nextLine().trim().toUpperCase();
            if (toastChoice.equals("Y")) {
                toasted = true;
                break;
            } else if (toastChoice.equals("N")) {
                toasted = false;
                break;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }

        // --- Create Sandwich and Add Toppings ---
        Sandwich sandwich = new Sandwich(breadType, size, toasted);
        toppingsMenu(sandwich);
        currentOrder.addSandwich(sandwich);

        System.out.println("Sandwich added to order!");
    }

    public void addSignatureSandwich() {
        System.out.println("\n---------- Signature Sandwiches ----------\n");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        System.out.println("3) Italian Classic");
        System.out.println("4) Veggie Supreme");
        System.out.print("Choose a signature sandwich: ");

        String input = scanner.nextLine().trim();
        Sandwich sandwich;

        switch (input) {
            case "1" -> sandwich = new BLT();
            case "2" -> sandwich = new PhillyCheeseSteak();
            case "3" -> sandwich = new ItalianClassic();
            case "4" -> sandwich = new VeggieSupreme();
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("Would you like to customize this sandwich? (Y/N): ");
        String customize = scanner.nextLine().trim().toUpperCase();
        if (customize.equals("Y")) {
            toppingsMenu(sandwich); // user can add/remove toppings
        }

        currentOrder.addSandwich(sandwich);
        System.out.println(((SignatureSandwich) sandwich).getName() + " added!");
    }

    public void toppingsMenu(Sandwich sandwich) {
        System.out.println("\n-----------------Toppings Menu-----------------");

        // --- Meats ---
        String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        System.out.println("\nMeat Options:");
        for (int i = 0; i < meats.length; i++) {
            System.out.printf("%d) %s%n", i + 1, meats[i]);
        }

        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] meatChoices = scanner.nextLine().split(",");

        for (String choice : meatChoices) {
            if (choice.trim().isEmpty()) continue;
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index < 0 || index >= meats.length) {
                    System.out.println("Invalid selection: " + choice.trim());
                    continue;
                }
                String meat = meats[index];
                System.out.printf("Add extra %s? (Y/N): ", meat);
                String extraInput = scanner.nextLine().trim().toUpperCase();
                boolean extra = extraInput.equals("Y");
                sandwich.addTopping(new Meat(meat, extra));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        // --- Cheeses ---
        String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"};
        System.out.println("\nCheese Options:");
        for (int i = 0; i < cheeses.length; i++) {
            System.out.printf("%d) %s%n", i + 1, cheeses[i]);
        }

        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] cheeseChoices = scanner.nextLine().split(",");
        for (String choice : cheeseChoices) {
            if (choice.trim().isEmpty()) continue;
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index < 0 || index >= cheeses.length) {
                    System.out.println("Invalid selection: " + choice.trim());
                    continue;
                }
                String cheese = cheeses[index];
                System.out.printf("Add extra %s cheese? (Y/N): ", cheese);
                String extraInput = scanner.nextLine().trim().toUpperCase();
                boolean extra = extraInput.equals("Y");
                sandwich.addTopping(new Cheese(cheese, extra));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        // --- Veggies ---
        String[] veggies = {
                "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
                "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
        };
        System.out.println("\nVeggie Topping Options:");
        for (int i = 0; i < veggies.length; i++) {
            System.out.printf("%d) %s%n", i + 1, veggies[i]);
        }

        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] toppingChoices = scanner.nextLine().split(",");
        Set<Integer> selectedRegularIndexes = new HashSet<>();

        for (String choice : toppingChoices) {
            if (choice.trim().isEmpty()) continue;
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index < 0 || index >= veggies.length || !selectedRegularIndexes.add(index)) {
                    System.out.println("Invalid or duplicate selection: " + choice.trim());
                    continue;
                }
                System.out.printf("Add extra %s? (Y/N): ", veggies[index]);
                String extraInput = scanner.nextLine().trim().toUpperCase();
                boolean extra = extraInput.equals("Y");
                sandwich.addTopping(new Veggie(veggies[index], extra));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
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
            if (choice.trim().isEmpty()) continue;
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index < 0 || index >= sauces.length) {
                    System.out.println("Invalid selection: " + choice.trim());
                    continue;
                }
                sandwich.addSauce(new Sauce(sauces[index]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        System.out.println("\nToppings added successfully!");
    }

    public void addDrink() {
        String[] drinkFlavors = {"Coca-Cola", "Pepsi", "Root Beer", "Fanta", "Sprite"};

        System.out.println("\n-----------------Drinks Menu-----------------");
        for (int i = 0; i < drinkFlavors.length; i++) {
            System.out.printf("%d) %s%n", i + 1, drinkFlavors[i]);
        }

        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] input = scanner.nextLine().split(",");
        boolean addedAny = false;

        for (String choice : input) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < drinkFlavors.length) {
                    String flavor = drinkFlavors[index];

                    String size;
                    while (true) {
                        System.out.println("\nSelect size: ");
                        System.out.println("S - $2.00");
                        System.out.println("M - $2.50");
                        System.out.println("L - $3.00");
                        System.out.println("\nChoice: ");
                        size = scanner.nextLine().trim().toUpperCase();
                        if (size.equals("S") || size.equals("M") || size.equals("L")) {
                            break;
                        } else {
                            System.out.println("Invalid size. Please enter S, M, or L.");
                        }
                    }

                    currentOrder.addDrink(new Drink(size, flavor));
                    addedAny = true;
                } else {
                    System.out.println("Invalid selection: " + choice.trim());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        System.out.println(addedAny ? "Drinks added to order." : "No drinks added.");
    }

    public void addChips() {
        String[] chipOptions = {
                "Lays - BBQ",
                "Hot Cheetos",
                "Ruffles - Original",
                "Pringles - Salt & Vinegar"
        };

        System.out.println("\n-----------------Chips Menu-----------------");
        for (int i = 0; i < chipOptions.length; i++) {
            System.out.printf("%d) %s%n", i + 1, chipOptions[i]);
        }

        System.out.print("Enter choice: For more than 1 selection insert comma (e.g., 1,3): ");
        String[] input = scanner.nextLine().split(",");
        boolean addedAny = false;

        for (String choice : input) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < chipOptions.length) {
                    String type = chipOptions[index];
                    currentOrder.addChips(new Chips(type));
                    addedAny = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        if (addedAny) {
            System.out.println("Chips added to order.");
        } else {
            System.out.println("No chips added.");
        }
    }

    public void addSide() {
        String[] sides = {"Au Jus", "Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

        System.out.println("\n-----------------Sides Menu-----------------");
        for (int i = 0; i < sides.length; i++) {
            System.out.printf("%d) %s%n", i + 1, sides[i]);
        }

        System.out.print("Enter choices (e.g., 2,2,5 for two Mayo and one Ranch): ");
        String[] input = scanner.nextLine().split(",");
        boolean addedAny = false;

        for (String choice : input) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < sides.length) {
                    currentOrder.addSide(new Side(sides[index]));
                    addedAny = true;
                } else {
                    System.out.println("Invalid selection: " + choice.trim());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice.trim());
            }
        }

        System.out.println(addedAny ? "Sides added to order." : "No sides added.");
    }

    public void checkout() {
        System.out.println("\n---------- Order Summary ----------\n");
        System.out.println(currentOrder.generateReceipt());
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
