package org.joseRodriguez;

import java.util.ArrayList;

public abstract class NpcSeller {

    private String name;
    protected ArrayList<Item> itemsToSell;

    private ArrayList<Order> itemsSold;

    public NpcSeller(String name) {
        this.name = name;
        this.itemsToSell = new ArrayList<Item>();
        this.itemsSold = new ArrayList<Order>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItemsToSell() {
        return itemsToSell;
    }

    public void setItemsToSell(ArrayList<Item> itemsToSell) {
        this.itemsToSell = itemsToSell;
    }

    public ArrayList<Order> getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(ArrayList<Order> itemsSold) {
        this.itemsSold = itemsSold;
    }

    public abstract void addItem(Item item) throws ToMuchForTheSellerException;

    public abstract void addItem() throws ToMuchForTheSellerException;
}
