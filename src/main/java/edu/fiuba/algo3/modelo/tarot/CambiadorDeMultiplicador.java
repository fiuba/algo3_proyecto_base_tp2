package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class CambiadorDeMultiplicador implements Tarot {
    private final int multiplicador;
    public CambiadorDeMultiplicador(int multiplicadorNuevos) {
        if (multiplicadorNuevos <= 0) {
            throw new MultiplicadorInvalidoTarotException();
        }
        this.multiplicador = multiplicadorNuevos;
    }
    public Puntaje obtenerPuntaje(Puntaje puntajeBase) {
        return new Puntaje(puntajeBase.obtenerPuntos(), multiplicador);
    }
}
