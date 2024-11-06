package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;
    public Mano mano;

    public Jugador() {
        this.puntaje = 0;
        this.mano = new Mano();
    }

    public int obtenerPuntaje() {
            return puntaje;
    }

    public Mano obtenerMano() {
        return mano;
    }

    public void tirarMano() {

    }
}
