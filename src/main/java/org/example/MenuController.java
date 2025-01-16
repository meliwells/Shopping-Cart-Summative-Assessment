package main.java.org.example;

public class MenuController {
    ConsoleIO io;

    //switch for menu choices
    private static final int CHOICE_DISPLAY_CART = 1;
    private static final int CHOICE_REMOVE_AN_ITEM = 2;
    private static final int CHOICE_ADD_AN_ITEM = 3;
    private static final int CHOICE_CHECKOUT = 4;
    private static final int CHOICE_EXIT = 5;

    private static final int MIN_CHOICE = 1;
    private static final int MAX_CHOICE = 5;

    public MenuController(ConsoleIO io) {
        this.io = io;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            printMainMenu();
            int choice = io.getIntegerInBetween("> ", MIN_CHOICE, MAX_CHOICE);

            switch (choice) {
                case CHOICE_DISPLAY_CART:
                    //method for displaying cart();
                    break;
                case CHOICE_REMOVE_AN_ITEM:
                    //method for removing an item();
                    break;
                case CHOICE_ADD_AN_ITEM:
                    //method for adding an item();
                    break;
                case CHOICE_CHECKOUT:
                    //method for checkout
                    break;
                case CHOICE_EXIT:
                    io.writeMessage("Thank you for visiting");
                    isRunning = false;
                    break;
            }
        }
    }

    public void printMainMenu() {
        io.writeMessage(">>> Main Menu <<<");
        io.writeMessage(CHOICE_DISPLAY_CART + ". Display Cart");
        io.writeMessage(CHOICE_REMOVE_AN_ITEM + ". Remove An Item");
        io.writeMessage(CHOICE_ADD_AN_ITEM + ". Add An Item");
        io.writeMessage(CHOICE_CHECKOUT + ". Checkout");
        io.writeMessage(CHOICE_EXIT + ". Exit");

    }
}
