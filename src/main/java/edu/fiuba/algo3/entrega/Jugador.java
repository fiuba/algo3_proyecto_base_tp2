package edu.fiuba.algo3.entrega;

public class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public boolean equals(Jugador j) {
        return this.nombre.equals(j.nombre);
    }
}
