package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class Puntaje {
    ArrayList<Jugada> jugadas;

    public Puntaje(ArrayList<Carta> cartas) {
        jugadas = new ArrayList<>();
        jugadas.add(new JugadaPar(cartas));
        jugadas.add(new JugadaFullHouse(cartas));
    }

    public int valor() {
        // Obtiene la jugada de mayor valor
        Jugada mejorJugada = jugadas.stream()
                .max(Comparator.comparing(Jugada::calcularPuntaje))
                .orElse(null);

        return mejorJugada.calcularPuntaje();
    }
}
