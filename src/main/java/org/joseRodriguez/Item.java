package org.joseRodriguez;

import java.util.Objects;

public class Item {
    private String name;
    private String type;
    private float price = 0;
    private byte state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(price, item.price) == 0 && state == item.state && Objects.equals(name, item.name) && Objects.equals(type, item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, state);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }
}
