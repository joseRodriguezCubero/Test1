package org.joseRodriguez;

import java.util.ArrayList;

public class City {
    private final String NAME;
    private ArrayList<NpcSeller> sellers;
    private ArrayList<Costumer> costumers;

    public City(String name) {
        this.NAME = name;
        this.sellers = new ArrayList<>();
        this.costumers = new ArrayList<>();
    }

    public String getNAME() {
        return NAME;
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

    public void addMerchant() {
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Merchant merchant = new Merchant(name);
        this.getSellers().add(merchant);
    }

    public void addCostumer() {
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Costumer costumer = new Costumer(name);
        this.getCostumers().add(costumer);
    }

    public static City searchCity(ArrayList<City> cities, String cityName) {
        return cities.stream()
                .filter(c -> c.getNAME().equals(cityName))
                .toList().get(0);
    }

    public static Costumer searchCostumer(City city, String costumerName) {
        return city.getCostumers().stream()
                .filter(c -> c.getName().equals(costumerName))
                .toList().get(0);
    }

    public static NpcSeller searchNpc(City city, String NpcName) {
        return city.getSellers().stream()
                .filter(c -> c.getName().equals(NpcName))
                .toList().get(0);
    }

    public static void addNpcSellerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        if (city != null) {
            Menu.choseMenu2(city);
        }
    }

    public static void addCostumerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        if (city != null) {
            city.addCostumer();
        }
    }

    public static void showAllNpcsByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city.getSellers().forEach(System.out::println);
    }

    public static City createOrReturnCity(City city) {
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

    public static void showAllItemsOfCostumerByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        Costumer costumer = searchCostumer(city, askCostumerName());
        costumer.getInventory().forEach(System.out::println);
        //TODO controlar los resultados nulos
    }

    public static void showAllItemsOfNpcByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        NpcSeller npc = searchNpc(city, askNpcName());
        npc.getInventory().forEach(System.out::println);
        //TODO controlar los resultados nulos
    }

    public static void showAllCostumersByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        city.getCostumers().forEach(System.out::println);
        //TODO controlar los resultados nulos
    }

    public static Item createItem(){
        String itemName = Entrada.leerString("Introduzca el nombre del Item.");
        String itemType = Entrada.leerString("Introduzca el tipo del Item.");
        float itemPrice = Entrada.leerFloat("Introduzca el precio del item.");
        return new Item(itemName,itemType,itemPrice);
    }

    public static void addItemToMerchand(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        city = createOrReturnCity(city);
        NpcSeller npc = searchNpc(city, askNpcName());
        try {
            npc.addItem(createItem());
        } catch (ToMuchForTheSellerException e) {
            throw new RuntimeException(e);
        }
        //TODO ----------------------------------continuar por aquí-------------------------------
    }

    public static String askCityName() {
        return Entrada.leerString("Introduzca el nombre de la ciudad");
    }

    public static String askCostumerName() {
        return Entrada.leerString("Introduzca el nombre del comprador");
    }

    public static String askNpcName() {
        return Entrada.leerString("Introduzca el nombre del vendedor");
    }
}
