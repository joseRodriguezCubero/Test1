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
    public void addCostumer(){
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Costumer costumer = new Costumer(name);
        this.getCostumers().add(costumer);
    }
    public static City searchCity(ArrayList<City> cities, String cityName) {
        return cities.stream()
                .filter(c -> c.getName().equals(cityName))
                .toList().get(0);
    }
    public static void addNpcSellerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        if(city != null){
            Menu.choseMenu2(city);
        }
    }
    public static void addCostumerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        if(city != null){
            city.addCostumer();
        }
    }

    public static void showAllNpcsByCity(ArrayList<City> cities){
        City city = searchCity(cities,askCityName());
        city.getSellers().forEach(System.out::println);
    }

    public static City createOrReturnCity(City city){
        if (city == null) {
            String answer = Entrada.leerString("No se ha encontrado la ciudad; desea crearla? (s/n)");
            if (answer.startsWith("s")) {
                return new City(askCityName());
            } else {
                System.out.println("volviendo al menu.");
                return null;
            }
        } else {
            return city;
        }
    }

    public static void showAllItemsOfCostumerByCity(ArrayList<City> cities){
        City city = searchCity(cities,askCityName());
        //TODO: finalizar showAllItemsOfCostumerByCity()
    }
    public static void showAllItemsOfNpcByCity(ArrayList<City> cities){
        //TODO: finalizar showAllItemsOfNpcByCity()
    }

    public static void showAllCostumersByCity(ArrayList<City> cities){
        City city = searchCity(cities,askCityName());
        city.getCostumers().forEach(System.out::println);
    }
    public static String askCityName(){
       return Entrada.leerString("Introduzca el nombre de la ciudad");
    }
}