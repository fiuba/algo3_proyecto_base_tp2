package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    Mazo mazo;
    Mano mano;

    public Jugador() {
        mazo = new Mazo();
        mano = new Mano();
    }

    public void repartirMano()  {
        mano.repartirUsando(mazo);
    }

    public int tamanioMano() {
        return mano.tamanio();
    }

    public Puntaje jugarMano(ArrayList<Carta> cartas) {
        return mano.calcularPuntaje(cartas);
    }
}
