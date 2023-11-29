package org.joseRodriguez;

import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private Costumer costumer;
    private ArrayList<Item> items;
    private City city;

    public Order(Costumer costumer, ArrayList<Item> items, City city) {
        this.costumer = costumer;
        this.items = items;
        this.city = city;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(costumer, order.costumer) && Objects.equals(items, order.items) && Objects.equals(city, order.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costumer, items, city);
    }

    @Override
    public String toString() {
        return "Order{" +
                "costumer=" + costumer +
                ", items=" + items +
                ", city=" + city +
                '}';
    }
}
