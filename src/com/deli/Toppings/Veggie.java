package com.deli.Toppings;

public class Veggie implements Topping{
    private String name;
    private boolean isExtra;

    public Veggie(String name, boolean isExtra){
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName() {
        return name + (isExtra ? " (extra" : "");
    }

    @Override
    public double getPrice(int size) {
        return 0.0;
    }
}
