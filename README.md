<div align="center">
<img src="https://github.com/user-attachments/assets/4750c029-5385-44a2-bf3b-a23df5757278" alt="Description" width="600" height="500">
</div>


# 🥪 DELI-cious: Sandwich Shop CLI Application

**DELI-cious** is a fully interactive, object-oriented Java CLI application that simulates a custom sandwich shop's point-of-sale system. Users can build sandwiches from scratch, order signature creations, add sides, chips, and drinks — and generate a detailed receipt on checkout.

---

## 📦 Features

- 🍞 **Custom Sandwich Builder**  
  Choose bread, size, toppings (including extras), sauces, and toasting options.

- 🥤 **Drinks, Chips, and Sides**  
  Add multiple drinks, chips, and sauces like au jus or ranch.

- ⭐ **Signature Sandwiches**  
  Try house specials like the BLT and Philly Cheese Steak — fully customizable.

- 🧾 **Dynamic Receipt Generation**  
  Orders are saved to timestamped `.txt` files in a `receipts/` folder.

- ✅ **Object-Oriented Design**  
  Uses clean, modular OOP principles including inheritance, polymorphism, and encapsulation.

---

## 📸 Screenshots
**🏠 Home Screen**

![Screenshot 2025-05-29 092553](https://github.com/user-attachments/assets/4a0f07ae-8560-438d-8d12-c82c9c3a7446)

**🥪 Sandwich Builder**
```java
Select Bread: White, Wheat, Rye, Wrap
Select Size: 4", 8", 12"
Choose Toppings, Sauces, and Toasting
```
***🧾 Example Receipt***

```java
Signature: BLT
  Bread: White
  Size: 8"
  Toasted: Yes
  Toppings: Bacon, Cheddar, Lettuce, Tomato
  Sauces: Ranch
  Sandwich Price: $11.75
```

## 🔍 Interesting Code: Signature Sandwiches

```java
public class BLT extends SignatureSandwich {
    public BLT() {
        super("BLT", "White", 8, true);
        addTopping(new Meat("Bacon", false));
        addTopping(new Cheese("Cheddar", false));
        addTopping(new RegularTopping("Lettuce", false));
        addTopping(new RegularTopping("Tomato", false));
        addSauce(new Sauce("Ranch"));
    }
}
```

This subclass demonstrates inheritance, encapsulation, and template instantiation — a clean way to manage predefined products.

