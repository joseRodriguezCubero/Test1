package org.joseRodriguez;

import java.util.ArrayList;

public class Peasant extends NpcSeller {

    public static final byte MAXITEMS = 5;
    public static final float TAX = 0.2f;

    public static final byte DAMAGE = 15;

    public Peasant(String name) {
        super(name);
    }

    @Override
    public void addItem(Item item) throws ToMuchForTheSellerException {
        byte state = (byte) (item.getState() - DAMAGE);
        item.setState(state);
        float tax = item.getPrice() * TAX;
        item.setPrice(item.getPrice() + tax);
        getInventory().add(item);
    }

    @Override
    public String toString() {
        return "Peasant{} " + super.toString();
    }
}
