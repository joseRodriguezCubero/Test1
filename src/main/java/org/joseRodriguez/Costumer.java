package org.joseRodriguez;

import java.util.ArrayList;

public class Costumer {
    private String name;

    private ArrayList<Item> inventory;

    public Costumer(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showItemsName() {
        this.inventory.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                '}';
    }
}
