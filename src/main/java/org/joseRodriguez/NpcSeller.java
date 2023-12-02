package org.joseRodriguez;

import java.util.ArrayList;

public abstract class NpcSeller {

    private String name;
    protected ArrayList<Item> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void showItemsName() {
        this.inventory.forEach(System.out::println);
    }

    public NpcSeller(String name) {
        this.name = name;
        this.inventory = new ArrayList<Item>();
    }

    public abstract void addItem(Item item) throws ToMuchForTheSellerException;

    @Override
    public String toString() {
        return "NpcSeller{" +
                "name='" + name + '\'' +
                '}';
    }
}