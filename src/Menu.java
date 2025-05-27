import java.util.Scanner;


public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void homeScreen() {
        boolean running = true;
        while (running){
            System.out.println("\n-----------------Home Screen-----------------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("\nChoice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1": orderScreen();
                    break;
                case "0": running = false;
                break;
                default:
                    System.out.println("Invalid Entry! Try Again");

            }
        }
    }
    public void orderScreen() {
        boolean running = true;
        while (running) {

            System.out.println("\n-----------------Order Screen-----------------");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("\nChoice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    System.out.println("Drink added!");
                    break;
                case "3":
                    System.out.println("Chips added!");
                    break;
                case "4":
                    System.out.println("Checking out...");
                    return;
                case "0":
                    System.out.println("Order canceled.");
                    return;
                default:
                    System.out.println("Invalid Entry! Try Again");
            }
        }
    }
    public void addSandwich(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Bread Type (White, Wheat, Rye, Wrap): ");
        String breadChoice = scanner.nextLine();
        System.out.println("Sandwich Size (4, 8, 12): ");
        String sizeChoice = scanner.nextLine();

        toppingsMenu();
    }
    public void toppingsMenu() {
        while (true) {
            System.out.println("\n-----------------Toppings Menu-----------------");
            System.out.println("Select Meat: ");
            System.out.println("Select Cheese: ");
            System.out.println("Would you like it toasted? ");
            System.out.println("Select Veggies: ");
            System.out.println("Select Sauces: ");
            System.out.println("Select Sides: ");
            System.out.println("Confirm Changes: 'Y'/'N' ");

        }
    }
    public void drinksMenu(){
        System.out.println("1) Coca-cola");
        System.out.println("2) Pepsi");
        System.out.println("3) Root Beer");
        System.out.println("4) Fanta");
        System.out.println("5) Sprite");
        System.out.println("Select Drink Size (S, M, L): ");
        System.out.println("Select Drink: ");
    }
    public void chipsMenu(){
        System.out.println("1) Lays - BBQ");
        System.out.println("1) Hot Cheetos");
        System.out.println("1) Ruffles - Original");
        System.out.println("1) Pringles - Salt & Vinegar");
        System.out.println("Select Chips: ");
    }
    public void checkout(){
        System.out.println("1) Confirm");
        System.out.println("1) Cancel");
    }
}