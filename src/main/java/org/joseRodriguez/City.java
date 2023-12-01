package org.joseRodriguez;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public void addPeasant() {
        String name = Entrada.leerString("introduzca el nombre del Campesino");
        Peasant peasant = new Peasant(name);
        this.getSellers().add(peasant);
    }

    public void addThief() {
        String name = Entrada.leerString("introduzca el nombre del Ladrón");
        Thief thief = new Thief(name);
        this.getSellers().add(thief);
    }
    public void addMerchant(){
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Merchant merchant = new Merchant(name);
        this.getSellers().add(merchant);
    }
    public static City searchCity(ArrayList<City> cities, String cityName) {
        return cities.stream()
                .filter(c -> c.getName().equals(cityName))
                .toList().get(0);
    }
    public static void addNpcSeller(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city == null) {
            String answer = Entrada.leerString("No se ha encontrado la ciudad; desea crearla? (s/n)");
            if (answer.startsWith("s")) {
                city = new City(askCityName());
            } else {
                System.out.println("volviendo al menu.");
            }
        } else {
            Menu.choseMenu2(city);
        }
    }
    public static String askCityName(){
       return Entrada.leerString("Introduzca el nombre de la ciduad");
    }
}