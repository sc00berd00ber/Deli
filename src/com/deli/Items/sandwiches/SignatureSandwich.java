package com.deli.Items.sandwiches;

public class SignatureSandwich extends Sandwich {
    private String name;

    public SignatureSandwich(String name, String breadType, int sizeInInches, boolean toasted) {
        super(breadType, sizeInInches, toasted);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
