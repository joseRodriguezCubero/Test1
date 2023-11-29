package org.joseRodriguez;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<NpcSeller> sellers;
    private ArrayList<Costumer> costumers;

    public City(String name) {
        this.name = name;
        this.sellers = new ArrayList<NpcSeller>();
        this.costumers = new ArrayList<Costumer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NpcSeller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<NpcSeller> sellers) {
        this.sellers = sellers;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;
    }
}