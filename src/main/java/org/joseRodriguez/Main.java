package org.joseRodriguez;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.joseRodriguez.City.searchCity;

public class Main {
    public static void main(String[] args) throws ToMuchForTheSellerException {

        ArrayList<City> cities = new ArrayList<City>();



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
