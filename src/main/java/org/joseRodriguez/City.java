package org.joseRodriguez;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class City {
    private final String NAME;
    private ArrayList<NpcSeller> sellers;
    private ArrayList<Costumer> costumers;

    public City(String name) {
        this.NAME = name;
        this.sellers = new ArrayList<>();
        this.costumers = new ArrayList<>();
    }

    private static Ganga apply(Item item) {
        return new Ganga(item, item.getPrice());
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

    public static void searchGanga(ArrayList<City> cities) { //TODO esta mal hay que hacer de una ciudad no de todas
        try {
            Ganga lowestPriceInfo = cities.stream()
                    .flatMap(c -> c.getSellers().stream())
                    .flatMap(s -> s.getInventory().stream()
                            .map(item -> new Ganga(item, item.getPrice())))
                    .min(Comparator.comparingDouble(Ganga::getPrice))
                    .orElse(null);
            if (lowestPriceInfo != null) {
                System.out.println("El precio más bajo de todos los ítems es: " + lowestPriceInfo.getPrice());
                System.out.println("Pertenece al item: " + Ganga.getItem());
            } else {
                System.out.println("No se encontró ningún item.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar la ganga: " + e.getMessage());
        }
    }

    public static List<Item> collectSellersItemsByType(ArrayList<City> cities, String type) {
       return cities.stream()
                .flatMap(c -> c.getSellers().stream())
                .flatMap(c -> c.getInventory().stream())
                .filter(item -> item.getType().equals(type))
                .toList();
    }
    public static List<Item> collectCostumersItemsByType(ArrayList<City> cities, String type) {
        return cities.stream()
                .flatMap(c -> c.getCostumers().stream())
                .flatMap(c -> c.getInventory().stream())
                .filter(item -> item.getType().equals(type))
                .toList();
    }

    public static void showItemsByTypeOrderedByPrice(ArrayList<City> cities){
        String type = askTypeOfItem();
        List<Item> allItems = Stream.concat(
                        collectCostumersItemsByType(cities, type).stream(),
                        collectSellersItemsByType(cities, type).stream())
                .toList();

        if (!allItems.isEmpty()) {
            List<Item> sortedItems = allItems.stream()
                    .sorted(Comparator.comparingDouble(Item::getPrice))
                    .toList();

            sortedItems.forEach(System.out::println);
        } else {
            System.out.println("No hay items del tipo: " + type);
        }
    }

    public static String askTypeOfItem(){
        return Entrada.leerString("Introduzca el tipo del Item.");
    }
    public static String askCityName() {
        return Entrada.leerString("Introduzca el nombre de la ciudad.");
    }

    public static String askCostumerName() {
        return Entrada.leerString("Introduzca el nombre del comprador.");
    }

    public static String askNpcName() {
        return Entrada.leerString("Introduzca el nombre del vendedor.");
    }
}
