package com.deli.Items;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor){
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice(){
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public String getDescription() {
        return size + " " + flavor;
    }
}
