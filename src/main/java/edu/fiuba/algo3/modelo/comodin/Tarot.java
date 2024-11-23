package edu.fiuba.algo3.modelo.comodin;
import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

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

