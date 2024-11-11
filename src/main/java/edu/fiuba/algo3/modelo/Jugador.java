package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    Mazo mazo;
    Mano mano;

    public Jugador() {
        this.mazo = new Mazo();
        this.mano = new Mano();
    }

    public void repartirMano()  {
        this.mazo.rellenarMano(this.mano);
    }

    public int tamanioMano() {
        return mano.tamanio();
    }

    public Puntaje jugarMano(ArrayList<Carta> cartas) {
        return mano.calcularPuntaje(cartas);
    }
}
