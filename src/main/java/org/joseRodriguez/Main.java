package org.joseRodriguez;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ToMuchForTheSellerException {

        ArrayList<City> cities = new ArrayList<City>();


        boolean exit = false;

        do {
            switch (menu()) {
                case 1:
                    addNpcSeller(cities);
                    break;
                case 2:
                    addItemToSeller(cities);
                    break;
                case 3:
                    metode3();
                    break;
                case 4:
                    metode3();
                    break;
                case 5:
                    metode3();
                    break;
                case 6:
                    metode3();
                    break;
                case 7:
                    metode3();
                    break;
                case 8:
                    metode3();
                    break;
                case 9:
                    metode3();
                    break;
                case 10:
                    metode3();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la aplicación");
                    exit = true;
                    break;
            }
        } while (!exit);

    }


    public static byte menu() {
        Scanner entrada = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 10;

        do {
            System.out.println("\n    MENú PRINCIPAL");
            System.out.println("1.  - Crear un vendedor.");
            System.out.println("2.  - Añadir un item al inventario de un vendedor.*");
            System.out.println("3.  - Mostrar el ítem más barato de todos los vendedores de una ciudad**");
            System.out.println("5.  - Crear un comprador");
            System.out.println("6.  - Realizar la compra de un ítem.");
            System.out.println("7.  - Consultar los ítems de un Comprador.**");
            System.out.println("8.  - Consultar todos los vendedores que hay en una ciudad.**");
            System.out.println("9.  - Consultar todos los compradores que hay en una ciudad.**");
            System.out.println("10. - Mostrar todos los ítems de un determinado tipo ordenados por precio (asc). **");
            System.out.println("0.  - Sortir de l'aplicació.\n");
            option = entrada.nextByte();
            if (option < MIN || option > MAX) {
                System.out.println("Escoge una opción válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }

    public static byte menu2() {
        Scanner entrada = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 3;

        do {
            System.out.println("\n    MENú PRINCIPAL");
            System.out.println("1.  - Crear un Mercader.");
            System.out.println("2.  - Crear un Ladrón.");
            System.out.println("3.  - Crear un campesino");
            System.out.println("0.  - Salir.\n");
            option = entrada.nextByte();
            if (option < MIN || option > MAX) {
                System.out.println("Escoge una opción válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }

    public static void addNpcSeller(ArrayList<City> cities) {
       String cityName = Entrada.leerString("introduzca la ciudad");
       City city = searchCity(cityName,cities);
       if(city == null){
           String answer = Entrada.leerString("No se ha encontrado la ciudad; desea crearla? (s/n)");
           if (answer.startsWith("s") ){
               city = new City(cityName);
           }else{
               System.out.println("volviendo al menu.");
           }
       }else{
           boolean exit2 = false;

           do {
               switch (menu2()) {
                   case 1:
                       addMerchant(city);
                       break;
                   case 2:
                       addThief(city);
                       break;
                   case 3:
                       addPeasant(city);
                       break;
                   case 0:
                       System.out.println("Volviendo al menú principal");
                       exit2 = true;
                       break;
               }
           } while (!exit2);

       }

    }

    private static void addPeasant(City city) {
        String name = Entrada.leerString("introduzca el nombre del Campesino");
        Peasant peasant = new Peasant(name);
        city.getSellers().add(peasant);
    }

    private static void addThief(City city) {
        String name = Entrada.leerString("introduzca el nombre del Ladrón");
        Thief thief = new Thief(name);
        city.getSellers().add(thief);
    }
    public static void addMerchant(City city){
        String name = Entrada.leerString("introduzca el nombre del mercader");
        Merchant merchant = new Merchant(name);
        city.getSellers().add(merchant);

    }

    public static City searchCity(String name, @NotNull ArrayList<City> cities) {

        City city = null;
        int i = 0;
        while (i < cities.size() && city == null) {
            if (cities.get(i).getName().equals(name)) {
                city = cities.get(i);
            }
            i++;
        }

        return city;
    }


    public static void metode3() {
        System.out.println("Mètode 3");
    }

    private static void addItemToSeller(ArrayList<City> cities) throws ToMuchForTheSellerException {
        String cityName = Entrada.leerString("introduzca la ciudad");
        City city = searchCity(cityName,cities);
        String sellerName = Entrada.leerString("Introduzca el nombre del vendedor");
        NpcSeller npc = searchNpc(sellerName,city.getSellers());
        if(npc != null){
            city.getSellers().add(npc);
        }else{
            System.out.println("lo sentimos el vendedor no existe.");
        }
        System.out.println("introduzca el item que desea añadir");

       /// npc.addItem(item);

        // me he quedado aquí..
    }

    public static NpcSeller searchNpc(String name, @NotNull ArrayList<NpcSeller> sellers) {

        NpcSeller npc = null;
        int i = 0;
        while (i < sellers.size() && npc == null) {
            if (sellers.get(i).getName().equals(name)) {
                npc = sellers.get(i);
            }
            i++;
        }

        return npc;
    }


    /*public static Item createItem(){
        Item item = new Item()
        return ;
    }*/
}
