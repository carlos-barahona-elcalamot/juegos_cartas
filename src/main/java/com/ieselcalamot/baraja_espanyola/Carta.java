package com.ieselcalamot.baraja_espanyola;

public class Carta {

    final private String palo;
    final private int numero;
    final private boolean esComodin;

    public Carta(String palo, int valor) throws InstantiationError {
        if (valor < 1 || valor > 12) {
            throw new InstantiationError("El valor de una carta debe estar entre 1 y 12");
        }
        this.palo = palo;
        this.numero = valor;
        this.esComodin = false;
    }

    private Carta() {
        esComodin = true;
        palo = null;
        numero = -1;
    }

    public static Carta crearComodin() {
        return new Carta();
    }

    public String getPalo() {
        if (esComodin) {
            throw new IllegalStateException("La carta comodin no tiene palo");
        }
        return palo;
    }

    public int getNumero() {
        if (esComodin) {
            throw new IllegalStateException("La carta comodin no tiene valor");
        }
        return numero;

    }

    public String getNombre() {
        String nombre = "";
        switch (numero) {
            case 1:
                nombre = "As";
                break;
            case 10:
                nombre = "Sota";
                break;
            case 11:
                nombre = "Caballo";
                break;
            case 12:
                nombre = "Rey";
                break;
            default:
                nombre = "" + numero;
                break;

        }
        return nombre + " de " + palo;
    }

}
