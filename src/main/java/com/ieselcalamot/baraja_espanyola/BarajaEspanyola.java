package com.ieselcalamot.baraja_espanyola;

import java.util.ArrayList;

public class BarajaEspanyola {

    final private String[] palos = { "OROS", "COPAS", "ESPADAS", "BASTOS" };

    final private int numeroComodines;
    final private boolean usar8sY9s;
    final private Carta[] baraja;
    private ArrayList<Carta> monton;

    public BarajaEspanyola(boolean usar8sY9s, int numeroComodines) throws InstantiationError {
        if (numeroComodines < 0 || numeroComodines > 2) {
            throw new InstantiationError("El número de comodines deber 0, 1, o 2");
        }
        this.numeroComodines = numeroComodines;
        this.usar8sY9s = usar8sY9s;
        baraja = new Carta[40 + numeroComodines + (usar8sY9s ? 8 : 0)];
        monton = new ArrayList<>(baraja.length);
        crearBaraja();
    }

    void crearBaraja() {
        int iCarta = 0;
        monton.clear();
        for (int i = 0; i < numeroComodines; i++) {
            Carta carta = Carta.crearComodin();
            baraja[iCarta++] = carta;
            monton.add(carta);
        }
        for (String palo : palos) {
            for (int valor = 1; valor < 13; valor++) {
                if (!((valor == 8 || valor == 9) && !usar8sY9s)) {
                    Carta carta = new Carta(palo, valor);
                    baraja[iCarta++] = carta;
                    monton.add(carta);
                }
            }
        }
    }

    public void barajar() {
        monton.clear();
        ArrayList<Carta> montonTemporal = new ArrayList<Carta>(baraja.length);
        for (Carta laCarta : baraja) {
            montonTemporal.add(laCarta);
        }
        for (int i = 0; i < baraja.length; i++) {
            int pos = (int) (Math.random() * montonTemporal.size());
            monton.add(montonTemporal.remove(pos));
        }

    }

    public Carta getSiguienteCarta() {
        return monton.size() > 0 ? monton.remove(monton.size() - 1) : null;
    }
}
