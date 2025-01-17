package main.java.org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    ConsoleIO io;
    ShoppingCartServices shoppingCartServices = new ShoppingCartServices();

    //switch for menu choices
    private static final int CHOICE_DISPLAY_CART = 1;
    private static final int CHOICE_REMOVE_AN_ITEM = 2;
    private static final int CHOICE_ADD_AN_ITEM = 3;
    private static final int CHOICE_CHECKOUT = 4;
    private static final int CHOICE_EXIT = 5;

    private static final int MIN_CHOICE = 1;
    private static final int MAX_CHOICE = 5;

    static ArrayList<Item> inventory = new ArrayList<>();

    public MenuController(ConsoleIO io) {
        this.io = io;
    }

    //create method to initialize inventory
    public void inventory() {
        inventory.add(new Item("Fruit", 0.50));
        inventory.add(new Item("Chips", 0.75));
        inventory.add(new Item("Granola Bar", 0.75));
        inventory.add(new Item("Soda", 1.25));
        inventory.add(new Item("Candy Bar", 1.00));
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            printMainMenu();
            int choice = io.getIntegerInBetween("> ", MIN_CHOICE, MAX_CHOICE);

            switch (choice) {
                case CHOICE_DISPLAY_CART:
                    choiceDisplayCart();
                    io.writeMessage("Display cart");
                    break;
                case CHOICE_REMOVE_AN_ITEM:
                    choiceRemoveAnItem();
                    io.writeMessage("Remove item");
                    break;
                case CHOICE_ADD_AN_ITEM:
                    choiceAddAnItem();
                    io.writeMessage("Add item");
                    break;
                case CHOICE_CHECKOUT:
                    //method for checkout
                    io.writeMessage("Checkout");
                    break;
                case CHOICE_EXIT:
                    io.writeMessage("Thank you for visiting!");
                    isRunning = false;
                    break;
            }
        }
    }

    public void printMainMenu() {
        io.writeMessage("--- Main Menu ---");
        io.writeMessage(CHOICE_DISPLAY_CART + ". Display Cart");
        io.writeMessage(CHOICE_REMOVE_AN_ITEM + ". Remove An Item");
        io.writeMessage(CHOICE_ADD_AN_ITEM + ". Add An Item");
        io.writeMessage(CHOICE_CHECKOUT + ". Checkout");
        io.writeMessage(CHOICE_EXIT + ". Exit");

    }

    public void choiceAddAnItem() {
        System.out.println("Current Inventory");
        int id = 1;
        for(Item item : inventory) {
            System.out.println(id + ": " + item);
            id++;
        }
        //for (Item item : inventory) {
            //System.out.println(item);
        //}
        Scanner scanner = new Scanner(System.in);
        //prompt user to select items and save to a new variable
        io.writeMessage("Enter the Id of the item you would like to add.");
        int itemId = scanner.nextInt();

        Item selectedItem = inventory.get(itemId - 1);

        //get quantity and save to new variable
        io.writeMessage("Enter the quantity you would like.");
        int quantity = scanner.nextInt();

        // call add item in services and pass in data from user
        ShoppingCartServices.addItem(selectedItem.getName(), selectedItem.getPrice(), quantity);
        System.out.println(quantity + " " + selectedItem.getName() + " was added to your cart.");
    }
    public void choiceDisplayCart() {
        shoppingCartServices.displayCart();
    }

    public void choiceRemoveAnItem() {
        shoppingCartServices.displayCart();
        Scanner scanner = new Scanner(System.in);
        io.writeMessage("Enter the Id of the item you want to remove.");
        int itemId = scanner.nextInt();
        ShoppingCartServices.removeItem(itemId);


    }

    /*public void displayInventory() {
        System.out.println("Current Inventory");
        int id = 1;
        for(Item item : inventory) {
            System.out.println(id + ": " + item);
            id++;
        }
    }*/
}
