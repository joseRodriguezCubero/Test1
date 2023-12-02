package org.joseRodriguez;

import java.util.ArrayList;

public class Thief extends NpcSeller{

    public static final byte MAXITEMS = 3;

    public static final float TAX = 1;

    public static final float DAMAGE = 2.5f;

    public Thief(String name) {
        super(name);
    }

    @Override
    public void addItem(Item item) throws ToMuchForTheSellerException {
        byte state = (byte) (item.getState()-DAMAGE);
        item.setState(state);
        float tax = item.getPrice()*TAX;
        item.setPrice(item.getPrice()+tax);
        getInventory().add(item);
    }

    @Override
    public String toString() {
        return "Thief{} " + super.toString();
    }
}
