package edu.fiuba.algo3.entrega_1;

import java.util.List;

public abstract class Pregunta {
    protected String pregunta;
    protected String tematica;
    protected List<String> opciones;

    public Pregunta(String pregunta, String tematica) {
        this.pregunta = pregunta;
        this.tematica = tematica;
    }

    public void mostrarPanel() {}
    public abstract int validarSeleccion(List<Number> seleccion);
}