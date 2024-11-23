package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Tarot {
    private Puntaje puntaje;

    public Tarot(int valor, int multiplicador) {
        this.puntaje = new Puntaje(valor, multiplicador);
    }
    public void aplicarA(Modificable modificable) {
        modificable.aplicarModificacion(this.puntaje);
    }
}

