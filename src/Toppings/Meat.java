package Toppings;

public class Meat implements Topping {
    private String name;
    private boolean isExtra;

    public Meat(String name, boolean isExtra){
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    @Override
    public double getPrice(int size) {
        double base = switch (size){
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.0;
        };
        return base + (isExtra ? switch (size){
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.0;
        }
        : 0);
    }
}
