package com.deli.Items;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor){
        this.size = size;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice(){
        return switch (size.toLowerCase()) {
            case "s" -> 2.00;
            case "m" -> 2.50;
            case "l" -> 3.00;
            default -> 0.0;
        };
    }
}
