import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String breadType;
    private int size;
    private boolean isToasted;
    private List<Topping> toppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();

    public Sandwich(String breadType, int size, boolean isToasted){
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }
    public double calculatePrice(){
        double basePrice = switch (size){
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };

        for (Topping topping : toppings){
            basePrice += topping.getPrice(size);
        }
        return basePrice;
    }
}
