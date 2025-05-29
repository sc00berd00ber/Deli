package com.deli.Items.sandwiches;

import com.deli.Toppings.Cheese;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Veggie;

public class VeggieSupreme extends SignatureSandwich{
    public VeggieSupreme() {
        super("Veggie Supreme", "Wrap", 8, false);
        addTopping(new Cheese("Swiss", false));
        addTopping(new Veggie("Lettuce", false));
        addTopping(new Veggie("Tomatoes", false));
        addTopping(new Veggie("Cucumbers", false));
        addTopping(new Veggie("Peppers", false));
        addTopping(new Veggie("Guacamole", false));
        addSauce(new Sauce("Ranch"));
    }
}
