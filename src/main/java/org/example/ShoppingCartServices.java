package main.java.org.example;

import java.util.HashMap;

public class ShoppingCartServices {
   HashMap<Item, Integer> cart = new HashMap<>();
   ConsoleIO io;


public void displayCart() {
   if (cart.isEmpty()) {
      io.writeMessage("Cart is empty");
   } else {
      io.writeMessage("Items in cart:");
      int itemCount = 0;
      for(Item key : cart.keySet()) {
          io.writeMessage(itemCount + ". Item: " + key + " Quantity: " + cart.get(key));
          itemCount++;
      }
   }
}

public void addItem(String name, double price, int quantity) {
    Item item = new Item(name, price);
    if(cart.containsKey(item)) {
        int newQuantity = cart.get(item) + quantity;
        cart.put(item, newQuantity);
    } else {
        cart.put(item, quantity);
    }
}

/*
    public void removeItem()
    list items in cart, ask what to remove and how many (if all or some)

    double checkout()
    double total -- go through all items in cart and add to total the price of item * quantity
    total = total cart
    remove all
    return total

    */


}
