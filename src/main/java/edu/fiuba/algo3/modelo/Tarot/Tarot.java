package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Tarot {
    private Puntaje puntaje;
    private String nombre;
    private String descripcion;
    private Modificable modificable;

    public Tarot(String nombre, String descripcion, Modificable modificable, Puntaje efecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificable = modificable;
        this.puntaje = efecto;
    }
    public void aplicarA(Modificable modificable) {
        modificable.aplicarModificacion(this.puntaje);
    }
}

