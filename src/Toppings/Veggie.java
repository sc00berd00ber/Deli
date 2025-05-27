package Toppings;

public class Veggie implements Topping{
    private String name;

    public Veggie(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice(int size) {
        return 0.0;
    }
}
