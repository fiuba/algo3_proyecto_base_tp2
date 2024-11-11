package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class JugadaPar extends Jugada{
    public JugadaPar(ArrayList<Carta> cartas) {

    }

    @Override
    public int calcularPuntaje() {
        return 5;
    }
}
