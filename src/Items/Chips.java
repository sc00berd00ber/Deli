package Items;

public class Chips {
    private String type;
    private final double price = 1.50;

    public String getDescription(){
        return type;
    }
    public double getPrice(){
        return price;
    }
}
