package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class CambiadorDeMultiplicador implements Tarot {
    private final int multiplicador;
    public CambiadorDeMultiplicador(int multiplicadorNuevo) {
        if (multiplicadorNuevo <= 0) {
            throw new MultiplicadorInvalidoTarotException();
        }
        this.multiplicador = multiplicadorNuevo;
    }
    public Puntaje obtenerPuntaje(Puntaje puntajeBase) {
        return new Puntaje(puntajeBase.obtenerPuntos(), multiplicador);
    }
}
