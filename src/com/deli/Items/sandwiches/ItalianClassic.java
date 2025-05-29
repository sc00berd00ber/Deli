package com.deli.Items.sandwiches;

import com.deli.Toppings.Cheese;
import com.deli.Toppings.Meat;
import com.deli.Toppings.Sauce;
import com.deli.Toppings.Veggie;

public class ItalianClassic extends SignatureSandwich{
    public ItalianClassic() {
        super("Italian Classic", "Wheat", 8, true);
        addTopping(new Meat("Salami", false));
        addTopping(new Meat("Ham", false));
        addTopping(new Cheese("Provolone", false));
        addTopping(new Veggie("Lettuce", false));
        addTopping(new Veggie("Tomatoes", false));
        addTopping(new Veggie("Onions", false));
        addSauce(new Sauce("Vinaigrette"));
    }
}
