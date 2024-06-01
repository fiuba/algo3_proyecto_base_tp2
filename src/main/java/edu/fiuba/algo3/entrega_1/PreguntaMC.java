package edu.fiuba.algo3.entrega_1;

import java.util.List;

public class PreguntaMC extends Pregunta {

    private TipoMC tipo;

    public PreguntaMC(String pregunta, String tematica, List<String> opciones, TipoMC tipo) {
        super(pregunta, tematica);
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public int validarSeleccion(List<Number> seleccion) {
        return tipo.validarSeleccion(seleccion);
    }
}
