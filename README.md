<div align="center">
<img src="https://github.com/user-attachments/assets/4750c029-5385-44a2-bf3b-a23df5757278" alt="Description" width="700" height="600">
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

![Screenshot 2025-05-30 132052](https://github.com/user-attachments/assets/3ff7c024-63a6-4f8d-8d6f-c4fbc8be2728)

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

## 📊 Flow Diagram

![Screenshot 2025-05-29 143858](https://github.com/user-attachments/assets/a88cf04d-85b0-4116-a74e-b04e6b2642ae)

## 🚀 Future Implementations & Improvements

**🖥 Graphical User Interface (GUI)**
Upgrade from CLI to a JavaFX or Swing-based GUI for a more user-friendly and visually intuitive experience.

**🗃 Persistent Order History**
Store all orders in a database (e.g., SQLite or MySQL) to support order lookups, analytics, and customer insights.

**🌐 Web or Mobile Integration**
Transform the app into a web-based or Android application using Spring Boot or Android Studio for real-time ordering.

**👥 Customer Accounts & Loyalty System**
Add customer login, saved favorite orders, and a point-based loyalty system to encourage repeat business.

**🧠 Smart Recommendation Engine**
Suggest sides, drinks, or sandwiches based on previous orders or trending items using basic machine learning or rule-based logic.

**📦 Inventory Management**
Track ingredient stock, auto-alert for low inventory, and generate purchase orders for resupply.

**🧾 Receipt Formatting Enhancements**
Add optional PDF receipt generation and email receipts with JavaMail integration.

**🌍 Multi-language Support**
Support multiple languages (i18n) to cater to a broader user base.

**🛠 Settings & Admin Panel**
Let shop managers modify sandwich templates, prices, or availability directly through the CLI or admin dashboard.

**🧪 Unit Testing Suite**
Integrate JUnit tests for individual components to ensure robustness during future feature additions.

**🔌 Plugin Architecture**
Allow modular addition of new sandwich types, sauces, or features without modifying the core system.
