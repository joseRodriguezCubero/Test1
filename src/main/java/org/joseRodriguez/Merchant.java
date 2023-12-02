package org.joseRodriguez;

public class Merchant extends NpcSeller {

    public static final byte MAXITEMS = 7;
    public static final float TAX = 0.4f;

    public Merchant(String name) {
        super(name);
    }

    @Override
    public void addItem(Item item) throws ToMuchForTheSellerException {
        float tax = item.getPrice() * TAX;
        item.setPrice(item.getPrice() + tax);
        getInventory().add(item);
    }

    @Override
    public String toString() {
        return "Merchant{} " + super.toString();
    }
}
