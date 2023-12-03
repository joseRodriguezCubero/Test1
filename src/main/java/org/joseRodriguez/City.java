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

    public static void showAllNpcsByCity(ArrayList<City> cities) { //TODO mirar si es necesario hacer mas excepciones
        City city = searchCity(cities, askCityName());
        if (city != null) {
            if (!city.getSellers().isEmpty()) {
                city.getSellers().forEach(System.out::println);
            } else {
                System.out.println("No hay vendedores en la ciudad");
            }
        }
    }

    public static City createCity(ArrayList<City> cities) {
        String answer = Entrada.leerString("No se ha encontrado la ciudad; desea crearla? (s/n)");

        while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
            System.out.println("Respuesta inválida. Por favor, ingrese 's' para sí o 'n' para no.");
            answer = Entrada.leerString("Desea crear la ciudad? (s/n)");
        }
        if (answer.equalsIgnoreCase("s")) {
            City city = new City(askCityName());
            cities.add(city);
            return city;
        } else {
            System.out.println("Volviendo al menú.");
            return null;
        }
    }

    public static void showAllItemsOfCostumerByCity(ArrayList<City> cities) { //TODO mirar si es necesario hacer mas excepciones
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

    public static void showAllItemsOfNpcByCity(City city) { //TODO mirar si es necesario hacer mas excepciones
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
            merchant.addItem(createItem());
            System.out.println("Item agregado al inventario del mercader.");
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del mercader está lleno. No se pudo agregar el item.");
        }
    }

    public static void addItemToThief(Thief thief) {
        try {
            thief.addItem(createItem());
            System.out.println("Item agregado al inventario del mercader.");
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del mercader está lleno. No se pudo agregar el item.");
        }
    }

    public static void addItemToPeasant(Peasant peasant) {
        try {
            peasant.addItem(createItem());
            System.out.println("Item agregado al inventario del mercader.");
        } catch (ToMuchForTheSellerException e) {
            System.out.println("El inventario del mercader está lleno. No se pudo agregar el item.");
        }
    }

    public static void searchGanga(City city) { //TODO verificar esto.
        try {
            Ganga lowestPriceInfo = city.getSellers().stream()
                    .flatMap(s -> s.getInventory().stream()
                            .map(item -> new Ganga(item, item.getPrice())))
                    .min(Comparator.comparingDouble(Ganga::getPrice))
                    .orElse(null);
            if (lowestPriceInfo != null) {
                System.out.println("El precio más bajo de todos los ítems en la ciudad " + city.getNAME() + " es: " + lowestPriceInfo.getPrice());
                System.out.println("Pertenece al ítem: " + Ganga.getItem());
            } else {
                System.out.println("No se encontró ningún ítem en la ciudad " + city.getNAME() + ".");
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

    public static void showItemsByTypeOrderedByPrice(ArrayList<City> cities){ //TODO mirar bien el method reference el código a veces se vuelve loco con ::getPrice
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

    public static void takeMyMoney(ArrayList<City> cities){ //TODO verificar esto
        City city = searchCity(cities, askCityName());
        Costumer costumer = searchCostumer(city, askCostumerName());
        NpcSeller npc = searchNpc(city, askNpcName());

        if (costumer != null && npc != null) {
            Item selectedItem = peekAnItem(npc);

            if (selectedItem != null) {
                processPurchase(costumer, npc, selectedItem);
            }
        }
    }

    private static void processPurchase(Costumer costumer, NpcSeller npc, Item selectedItem) { //TODO verificar esto
        try {
            npc.removeItem(selectedItem);
            costumer.addItem(selectedItem);

            System.out.println("Compra realizada con éxito. " + costumer.getName() + " ha comprado: " + selectedItem);
        } catch (NoMoneyMyFriendException e) {
            System.out.println("No tienes suficiente dinero para comprar este artículo.");
        }
    }

    public static Item peekAnItem(NpcSeller npc) {   //TODO verificar esto
        boolean exit = false;
        Item selected = null;
        while (!exit) {
            System.out.println("Los items del vendedor " + npc.getName() + " son:");
            int count = 1;
            for (Item item : npc.getInventory()) {
                System.out.println(count + ": " + item);
                count++;
            }
            System.out.println("0: Salir");
            int option = Entrada.leerByte("Introduzca el número del item (o 0 para salir): ");
            if (option == 0) {
                exit = true;
            } else if (option >= 1 && option <= npc.getInventory().size()) {
                selected = npc.getInventory().get(option - 1);
                System.out.println("Has seleccionado: " + selected);
            } else {
                System.out.println("Opción inválida. Por favor, elige un número válido.");
            }
        }
        return selected;
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
