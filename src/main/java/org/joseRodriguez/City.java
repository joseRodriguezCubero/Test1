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
        System.out.println("Campesino creado");
    }

    public void addThief() {
        String name = Entrada.leerString("introduzca el nombre del Ladrón");
        Thief thief = new Thief(name);
        this.getSellers().add(thief);
        System.out.println("Ladrón creado");
    }

    public void addMerchant() {
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Merchant merchant = new Merchant(name);
        this.getSellers().add(merchant);
        System.out.println("Mercader creado");
    }

    public void addCostumer() {
        String name = Entrada.leerString("introduzca el nombre del comprador");
        Costumer costumer = new Costumer(name);
        this.getCostumers().add(costumer);
        System.out.println("Comprador creado");
    }

    public static City searchCity(ArrayList<City> cities, String cityName) {
        try {
            return cities.stream()
                    .filter(c -> c.getNAME().equals(cityName))
                    .toList().get(0);
        }catch (ArrayIndexOutOfBoundsException e){
            return createCity(cities);
        }
    }

    public static Costumer searchCostumer(City city, String costumerName) throws ArrayIndexOutOfBoundsException {
        return city.getCostumers().stream()
                .filter(c -> c.getName().equals(costumerName))
                .toList().get(0);
    }

    public static NpcSeller searchNpc(City city, String NpcName) throws ArrayIndexOutOfBoundsException {
        return city.getSellers().stream()
                .filter(c -> c.getName().equals(NpcName))
                .toList().get(0);
    }

    public static void addNpcSellerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            Menu.choseMenu2(city);
        }
    }

    public static void addCostumerInCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            city.addCostumer();
        }
    }

    public static void showAllNpcsByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            if (!city.getSellers().isEmpty()) {
                city.getSellers().forEach(System.out::println);
            } else {
                System.out.println("No hay vendedores en la ciudad");
            }
        }
    }


    public static City createCity(ArrayList<City> cities) { //TODO mejorar verificación.
            String answer = Entrada.leerString("No se ha encontrado la ciudad; desea crearla? (s/n)");
            if (answer.startsWith("s")) {
                City city = new City(askCityName());
                cities.add(city);
                return city;
            } else {
                System.out.println("volviendo al menu.");
                return null;
            }
    }

    public static void showAllItemsOfCostumerByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            Costumer costumer = searchCostumer(city, askCostumerName());
            if (costumer != null) {
                if (!costumer.getInventory().isEmpty()) {
                    costumer.getInventory().forEach(System.out::println);
                } else {
                    System.out.println("El inventario está vacío");
                }
            } else {
                System.out.println("El comprador no se encuentra en la ciudad: " + city.getNAME());
            }
        }
    }

    public static void showAllItemsOfNpcByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            NpcSeller npc = searchNpc(city, askNpcName());
            if (npc != null) {
                if (!npc.getInventory().isEmpty()) {
                    npc.getInventory().forEach(System.out::println);
                } else {
                    System.out.println("El inventario está vacío");
                }
            } else {
                System.out.println("El vendedor no se encuentra en la ciudad: " + city.getNAME());
            }
        }
    }

    public static void showAllCostumersByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            if (!city.getCostumers().isEmpty()) {
                city.getCostumers().forEach(System.out::println);
            } else {
                System.out.println("No hay compradores en la ciudad");
            }
        }
    }

    public static Item createItem() {
        String itemName = Entrada.leerString("Introduzca el nombre del Item.");
        String itemType = Entrada.leerString("Introduzca el tipo del Item.");
        float itemPrice = Entrada.leerFloat("Introduzca el precio del item.");
        return new Item(itemName, itemType, itemPrice);
    }

    public static void addItemToNpcByCity(ArrayList<City> cities) {
        City city = searchCity(cities, askCityName());
        if (city != null) {
            NpcSeller npc = searchNpc(city, askNpcName());
            if (npc != null){
                if (npc instanceof Merchant) {
                    addItemToMerchant((Merchant) npc);
                } else if (npc instanceof Thief) {
                    addItemToThief((Thief) npc);
                } else if (npc instanceof Peasant) {
                    addItemToPeasant((Peasant) npc);
                }
            }else{
                System.out.println("Vendedor no encontrado.");
            }
        }
    }

    public static void addItemToMerchant(Merchant merchant) {
        try {
            if (merchant.getInventory().size() < Merchant.MAXITEMS) {
                merchant.addItem(createItem());
            }
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del mercader está lleno.");
        }
    }

    public static void addItemToThief(Thief thief) {
        try {
            if (thief.getInventory().size() < Thief.MAXITEMS) {
                thief.addItem(createItem());
            }
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del ladrón está lleno.");
        }
    }

    public static void addItemToPeasant(Peasant peasant) {
        try {
            if (peasant.getInventory().size() < Peasant.MAXITEMS) {
                peasant.addItem(createItem());
            }
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del campesino está lleno.");
        }
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
