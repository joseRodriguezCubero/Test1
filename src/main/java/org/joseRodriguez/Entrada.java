package org.joseRodriguez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    private static final Scanner sc = new Scanner(System.in);

    public Entrada() {
    }

    public static byte leerByte(String mensaje) {
        byte numero = 0;
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextByte();
                acierto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipo de datos introducidos.");
            }
            sc.nextLine();
        } while (!acierto);
        return numero;
    }

    public static int leerInt(String mensaje) {
        int numero = 0;
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextInt();
                acierto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipo de datos introducidos.");
            }
            sc.nextLine();
        } while (!acierto);
        return numero;
    }


    public static float leerFloat(String mensaje) {
        float numero = 0.0f;
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextFloat();
                acierto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipo de datos introducidos.");
            }
            sc.nextLine();
        } while (!acierto);
        return numero;
    }


    public static double leerDouble(String mensaje) {
        double numero = 0.0;
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextDouble();
                acierto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipo de datos introducidos.");
            }
            sc.nextLine();
        } while (!acierto);
        return numero;
    }

    public static char leerChar(String mensaje) {
        char caracter = 0;
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                caracter = sc.next().charAt(0);
                acierto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipo de datos introducidos.");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            sc.nextLine();
        } while (!acierto);
        return caracter;
    }


    public static String leerString(String mensaje) {
        String lectura = "";
        boolean acierto = false;

        do {
            System.out.println(mensaje);
            try {
                lectura = sc.nextLine();
                acierto = true;
            } catch (Exception e) {
                System.out.println("Error en el mensaje.");
            }
        } while (!acierto);
        return lectura;
    }

    public static boolean leerSiNo(String mensaje) {
        boolean acierto = false;
        String lectura = "";
        boolean resultado = false;

        do {
            System.out.println(mensaje);
            try {
                lectura = sc.nextLine().toUpperCase();
                acierto = true;
                if (lectura.charAt(0) == 'S') {
                    resultado = true;
                } else if (lectura.charAt(0) == 'N') {
                    resultado = false;
                } else {
                    System.out.println("error, introduzca caracter válido.");
                    acierto = false;
                }
            } catch (Exception e) {
                System.out.println("Error al introducir caracter.");
            }
        } while (!acierto);
        return resultado;
    }

}