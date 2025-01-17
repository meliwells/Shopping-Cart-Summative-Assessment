package main.java.org.example;

public class App {
    //main
    public static void main( String[] args ){
        ConsoleIO io = new ConsoleIO();
        MenuController menuController = new MenuController(io);
        //menuController.printMainMenu();
        menuController.run();
    }
}
