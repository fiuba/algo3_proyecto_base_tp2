package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class JugadaPar extends Jugada{
    public JugadaPar(ArrayList<Poker> cartas) {

    }

    @Override
    public int calcularPuntaje() {
        return 5;
    }
}
