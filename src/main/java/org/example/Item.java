package main.java.org.example;

import java.util.Objects;

public class Item {
    private String name;
    private double price;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return Double.compare(getPrice(), item.getPrice()) == 0 && Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Item{" + "itemName='" + name + '\'' +
                ", price=" + price + '}';
    }

}
