package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class JugadaFactory {
    public Jugada obtenerJugada(ArrayList<Poker> cartas) {
        // Filtra las cartas que intervienen en la jugada.
        return new JugadaPar(cartas);
    }
}
