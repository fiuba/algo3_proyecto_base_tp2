package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class SinTarot implements Tarot {
    public Puntaje obtenerPuntaje(Puntaje puntajeBase) {
        return puntajeBase;
    }
}
