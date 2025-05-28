package com.deli.Items.sandwiches;

import com.deli.Toppings.Cheese;
import com.deli.Toppings.Meat;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Veggie;

public class BLT extends SignatureSandwich{
    public BLT() {
        super("BLT", "White", 8, true);
        addTopping(new Meat("Bacon", false));
        addTopping(new Cheese("Cheddar", false));
        addTopping(new Veggie("Lettuce", false));
        addTopping(new Veggie("Tomato", false));
        addSauce(new Sauce("Ranch"));
    }
}
