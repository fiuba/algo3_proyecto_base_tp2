package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class JugadaFullHouse extends Jugada {
    public JugadaFullHouse(ArrayList<Poker> cartas) {

    }

    @Override
    public int calcularPuntaje() {
        return 10;
    }
}
