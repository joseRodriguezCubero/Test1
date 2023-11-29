package org.joseRodriguez;

import java.util.InputMismatchException;
import java.util.Scanner;

/*Clase para manejar la entrada de datos de teclado*/
public class Entrada {

    private static final Scanner sc = new Scanner(System.in);
    // (me preocupaba cerrar el scanner asi que he probado con el try with resources
    // en vez ce poner un finlly en cada método. (no funciona).

    public Entrada() {
    }

    // Mètodes a implantar capturant l’excepció de la classe InputMismatchException:

    // recibe mensaje y devuelve numero byte.
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

    // recibe mensaje y devuelve numero int.
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

    // recibe mensaje y devuelve numero float.
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

    // recibe mensaje y devuelve numero double.
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

    // Mètodes a implantar capturant l’excepció de la classe Exception:

    // recibe mensaje y devuelve char.
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

    // recibe mensaje y devuelve mensaje string.
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

    // recibe mensaje y devuelve booleano.
    // si l’usuari/ària introdueix “s”, retorna “true”, si l’usuari
    // introdueix “n”, retorna “false”.
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