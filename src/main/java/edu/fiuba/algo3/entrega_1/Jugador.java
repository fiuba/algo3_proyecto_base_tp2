package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int puntajeTotal;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntajeTotal = 0;
    }

    public List<Number> obtenerJugada() {
        return new ArrayList<Number>();
    }

    public int obtenerPuntaje() {
        return puntajeTotal;
    }

    public void sumarPuntaje(int puntaje) {
        puntajeTotal = puntaje + puntajeTotal;
    }
}
