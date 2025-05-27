package com.deli.Toppings;

public class Cheese  implements Topping{
    private String name;
    private boolean isExtra;

    public Cheese(String name, boolean isExtra){
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName(){
        return name + (isExtra? " (extra)" : "");
    }

    @Override
    public double getPrice(int size) {
        double base = switch (size){
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.0;
        };
        return base + (isExtra ? switch (size){
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.0;
        }
        : 0);
    }
}
