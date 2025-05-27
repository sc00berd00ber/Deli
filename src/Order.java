import Items.Chips;
import Items.Drink;
import Items.Sandwich;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private LocalDateTime timestamp = LocalDateTime.now();

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
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
}
