package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class CambiadorDePuntos implements Tarot{
    private final int puntos;
    public CambiadorDePuntos(int puntosNuevos) {
        if (puntosNuevos < 0) {
            throw new PuntosNegativosTarotException();
        }
        this.puntos = puntosNuevos;
    }
    public Puntaje obtenerPuntaje(Puntaje puntajeBase) {
        return new Puntaje(puntos, puntajeBase.obtenerMultiplicador());
    }
}
