package org.joseRodriguez;

import java.util.ArrayList;

public class Costumer {
    private String name;
    private float money;
    private ArrayList<Item> inventory;

    public Costumer(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.money = 1000.0f;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void showItemsName() {
        this.inventory.forEach(System.out::println);
    }

    public void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public void addItem(Item item) throws NoMoneyMyFriendException {
        if (money >= item.getPrice()) {
            inventory.add(item);
            money -= item.getPrice();
        } else {
            throw new NoMoneyMyFriendException("El comprador no tiene suficiente dinero para comprar este item.");
        }
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                '}';
    }
}
