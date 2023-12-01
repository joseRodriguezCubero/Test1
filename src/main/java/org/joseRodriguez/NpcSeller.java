package org.joseRodriguez;

import java.util.ArrayList;

public abstract class NpcSeller {

    private String name;
    protected ArrayList<Item> inventory;


    public void showItemsName() {
    this.inventory.forEach(System.out::println);
    }

    public NpcSeller(String name) {
        this.name = name;
        this.inventory = new ArrayList<Item>();
    }



}