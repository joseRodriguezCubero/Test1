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
        if (inventory.size() < MAXITEMS) {
            byte state = (byte) (item.getState() - DAMAGE);
            item.setState(state);
            float tax = item.getPrice() * TAX;
            item.setPrice(item.getPrice() + tax);
            inventory.add(item);
        } else {
            throw new ToMuchForTheSellerException("El inventario del campesino está lleno.");
        }
    }
    @Override
    public String toString() {
        return "Peasant{} " + super.toString();
    }
}
