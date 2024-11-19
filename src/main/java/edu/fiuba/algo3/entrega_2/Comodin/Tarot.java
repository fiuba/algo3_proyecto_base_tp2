package edu.fiuba.algo3.entrega_2.Comodin;

import edu.fiuba.algo3.entrega_1.Modificable.Modificable;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class Tarot {
    private Puntaje puntaje;
    private String descripcion;
    private String nombre;

    public Tarot(String descripcion, String nombre, int valor, int multiplicador) {
        this.puntaje = new Puntaje(valor, multiplicador);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    public void aplicarA(Modificable modificable) {
        modificable.aplicarModificacion(this.puntaje);
    }
}
