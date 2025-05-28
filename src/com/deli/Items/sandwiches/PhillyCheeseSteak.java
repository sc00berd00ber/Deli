package com.deli.Items.sandwiches;

import com.deli.Toppings.Cheese;
import com.deli.Toppings.Meat;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Veggie;

public class PhillyCheeseSteak extends SignatureSandwich{
    public PhillyCheeseSteak() {
        super("Philly Cheese Steak", "White", 8, true);
        addTopping(new Meat("Steak", false));
        addTopping(new Cheese("American", false));
        addTopping(new Veggie("Peppers", false));
        addSauce(new Sauce("Mayo"));
    }
}
