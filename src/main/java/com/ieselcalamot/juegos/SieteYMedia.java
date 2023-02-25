package com.ieselcalamot.juegos;

import com.ieselcalamot.baraja_espanyola.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SieteYMedia {

    private float puntosJugador = 0;
    private float puntosBanca = 0;
    private BarajaEspanyola baraja = new BarajaEspanyola(false, 0);

    private float getPuntosCarta(Carta carta) {
        return carta.getNumero() > 7 ? 0.5f : carta.getNumero();
    }

    private void juegaJugador() throws IOException {

        BufferedReader consola = new BufferedReader(
                new InputStreamReader(System.in));

        String seguirJugando = "";
        do {
            System.out.println("");
            Carta cartaExtraida = baraja.getSiguienteCarta();
            puntosJugador += getPuntosCarta(cartaExtraida);
            System.out.println("Ha salido el " + cartaExtraida.getNombre());
            System.out.println("Tienes " + puntosJugador + " puntos.");
            if (puntosJugador < 7.5f) {
                System.out.print("¿ Quieres otra carta?(s/n): ");
                seguirJugando = consola.readLine();

            }

        } while (puntosJugador < 7.5f && seguirJugando.equalsIgnoreCase("s"));
    }

    private void juegaBanca() {

        do {
            System.out.println("");
            System.out.println("La banca coge carta: ");
            Carta cartaExtraida = baraja.getSiguienteCarta();
            puntosBanca += getPuntosCarta(cartaExtraida);
            System.out.println("Ha salido el " + cartaExtraida.getNombre());
            System.out.println("La banca tiene " + puntosBanca + " puntos.");
        } while (puntosBanca < 7.5f && puntosBanca <= puntosJugador);
    }

    public void jugar() throws IOException {
        System.out.println("BIENVENIDO AL JUEGO SIETE Y MEDIA");
        baraja.barajar();
        System.out.println("-----------------------------------");
        System.out.println("Juega el jugador");
        juegaJugador();
        System.out.println("-----------------------------------");
        if (puntosJugador < 7.5f) {
            System.out.println("Juega la banca");
            juegaBanca();
        }
        System.out.println("");
        if (puntosJugador > puntosBanca && puntosJugador <= 7.5f || puntosBanca > 7.5f) {
            System.out.println("---  GANA EL JUGADOR ---");
        } else {
            System.out.println("---  GANA LA BANCA ---");
        }
    }
}
