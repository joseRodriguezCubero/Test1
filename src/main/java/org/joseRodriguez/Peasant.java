package org.joseRodriguez;

import java.util.ArrayList;

public class Peasant extends NpcSeller{

    public Peasant(String name) {
        super(name);
    }

    @Override
    public void addItem(Item item) throws ToMuchForTheSellerException{
    if(itemsToSell.size()< 5){
        float price = (float) (item.getPrice() + (item.getPrice()*0.2));
        item.setPrice(price);
        itemsToSell.add(item);
    }
    }
}
