package com.deli;

import com.deli.Items.Chips;
import com.deli.Items.Drink;
import com.deli.Items.sandwiches.Sandwich;
import com.deli.Items.Side;
import com.deli.Items.sandwiches.SignatureSandwich;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Topping;
import java.util.Collections;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private LocalDateTime timestamp = LocalDateTime.now();

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }
    public void addSide(Side side) {
        sides.add(side);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }
    public void addChips(Chips chip){
        chips.add(chip);
    }

    public double calculateTotal(){
        double total = 0.0;
        for (Sandwich s : sandwiches)
            total += s.calculatePrice();
        for (Drink d : drinks)
            total += d.getPrice();
        for (Chips c : chips)
            total += c.getPrice();
        return total;
    }

    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();

        List<Sandwich> reversedSandwiches = new ArrayList<>(sandwiches);
        Collections.reverse(reversedSandwiches);

        int count = 1;
        for (Sandwich s : reversedSandwiches) {
            if (s instanceof SignatureSandwich ss) {
                sb.append("Signature: ").append(ss.getName()).append("\n");
            }
            sb.append("Sandwich ").append(count++).append(":\n");
            sb.append("  Bread: ").append(s.getBreadType()).append("\n");
            sb.append("  Size: ").append(s.getSize()).append("\"\n");
            sb.append("  Toasted: ").append(s.isToasted() ? "Yes" : "No").append("\n");

            sb.append("  Toppings:\n");
            for (Topping t : s.getToppings()) {
                sb.append("    - ").append(t.getName()).append("\n");
            }

            sb.append("  Sauces:\n");
            for (Sauce sauce : s.getSauces()) {
                sb.append("    - ").append(sauce.getName()).append("\n");
            }

            sb.append("  Sandwich Price: $").append(String.format("%.2f", s.calculatePrice())).append("\n\n");
        }

        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            List<Drink> reversedDrinks = new ArrayList<>(drinks);
            Collections.reverse(reversedDrinks);
            for (Drink d : reversedDrinks) {
                sb.append("  - ").append(d.getFlavor())
                        .append(" ($").append(String.format("%.2f", d.getPrice())).append(")\n");
            }
            sb.append("\n");
        }

        if (!chips.isEmpty()) {
            sb.append("Chips:\n");
            List<Chips> reversedChips = new ArrayList<>(chips);
            Collections.reverse(reversedChips);
            for (Chips c : reversedChips) {
                sb.append("  - ").append(c.getType())
                        .append(" ($").append(String.format("%.2f", c.getPrice())).append(")\n");
            }
            sb.append("\n");
        }

        if (!sides.isEmpty()) {
            sb.append("Sides:\n");
            List<Side> reversedSides = new ArrayList<>(sides);
            Collections.reverse(reversedSides);
            for (Side s : reversedSides) {
                sb.append("  - ").append(s.getDescription()).append("\n");
            }
            sb.append("\n");
        }


        sb.append("---------------------------\n");
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");

        return sb.toString();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
