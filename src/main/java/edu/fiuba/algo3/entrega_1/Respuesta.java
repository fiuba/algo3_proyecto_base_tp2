package edu.fiuba.algo3.entrega_1;

public class Respuesta {
    private Jugador jugador;
    private int puntajeBase;

    public Respuesta(Jugador jugador, int puntajeBase) {
        this.jugador = jugador;
        this.puntajeBase = puntajeBase;
    }

    public void actualizarPuntajeDelJugador() {
        jugador.sumarPuntaje(puntajeBase);
    }
}
