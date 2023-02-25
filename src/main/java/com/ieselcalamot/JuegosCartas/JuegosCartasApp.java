package com.ieselcalamot.JuegosCartas;

import com.ieselcalamot.juegos.SieteYMedia;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class JuegosCartasApp {
    private JuegosCartasApp() {
    }

    public static void main(String[] args) throws IOException {

        System.out.println("BIENVENIDO A JUEGOS DE CARTAS");
        System.out.println("");

        BufferedReader consola = new BufferedReader(
                new InputStreamReader(System.in));

        String opcion = "";
        do {
            System.out.println("");
            System.out.println("Menú:");
            System.out.println("  1. Siete y media");
            System.out.println("  2. El cinquillo");
            System.out.println("  0. Salir");
            System.out.print("Elige el juego que quieres jugar o 0 para salir: ");
            opcion = consola.readLine();
            switch (opcion) {
                case "1":
                    (new SieteYMedia()).jugar();
                    break;
                case "2":
                    System.out.println("Lo siento, este juego todavía no está implementado...");
                    break;
                case "0":
                    System.out.println("¡¡ Gracias por jugar conmigo !!");
                    break;
                default:
                    System.out.println("Opción desconocida. Vuelve a intentarlo.");
            }

        } while (!opcion.equalsIgnoreCase("0"));
    }
}
