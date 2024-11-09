package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class Color extends Juego{
    public Puntaje puntuarMano(ArrayList<Carta> cartas) {
        Puntaje puntaje = new Puntaje(35, 4);
        for (Carta carta : cartas) {
            puntaje.sumarPuntos(carta.obtenerPuntaje());
        }
        return puntaje;
    }

    public boolean sosJuego(ArrayList<Carta> cartas) {
        if (cartas.size() != 5) {
            return false;
        }
        Carta cartaPalo = cartas.get(0);
        for (Carta carta : cartas.subList(1, cartas.size())) {
            if (!carta.esDelMismoPalo(cartaPalo)) {
                return false;
            }
        }
        return true;
    }
}
