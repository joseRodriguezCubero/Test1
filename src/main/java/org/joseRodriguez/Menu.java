package org.joseRodriguez;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static byte showMenu() {
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
    public static byte showMenu2() {
        Scanner entrada = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 3;

        do {
            System.out.println("\n    MENú PRINCIPAL");
            System.out.println("1.  - Crear un Mercader.");
            System.out.println("2.  - Crear un Ladrón.");
            System.out.println("3.  - Crear un campesino");
            System.out.println("0.  - Volver al menú anterior.\n");
            option = entrada.nextByte();
            if (option < MIN || option > MAX) {
                System.out.println("Escoge una opción válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }
    public static void choseMenu(ArrayList<City> cities){
        boolean exit = false;

        do {
            switch (showMenu()) {
                case 1:
                    City.addNpcSellerInCity(cities);
                    break;
                case 2:
                    //TODO: addItemToSeller(cities);
                    break;
                case 3:
                    //TODO: Mostrar el Item más barato de todos los vendedores de una ciudad (lambdas).
                    break;
                case 4:
                    //TODO: Consultar los ítems de un vendedor (lambdas).
                    break;
                case 5:
                    City.addCostumerInCity(cities);
                    break;
                case 6:
                    //TODO: Realizar la compra de un ítem.
                    break;
                case 7:
                    //TODO: Consultar los ítems de un Comprador.(lambas)
                    break;
                case 8:
                    City.showAllNpcsByCity(cities);
                    break;
                case 9:
                    City.showAllCostumersByCity(cities);
                    break;
                case 10:
                    //TODO: Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) (lamdas).
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la aplicación");
                    exit = true;
                    break;
            }
        } while (!exit);

    }
    public static void choseMenu2(City city){
        boolean exit2 = false;

        do {
            switch (showMenu2()) {
                case 1:
                    city.addMerchant();
                    break;
                case 2:
                    city.addThief();
                    break;
                case 3:
                    city.addPeasant();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    exit2 = true;
                    break;
            }
        } while (!exit2);

    }
}


