package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.List;

public class PreguntaVF extends Pregunta {
    private TipoVF tipo;
    private Number opcionCorrecta;

    public PreguntaVF(String pregunta, String tematica, Number opcionCorrecta, TipoVF tipo) {
        this.opciones = new ArrayList<String>();
        this.opciones.add("Falso");
        this.opciones.add("Verdadero");
        this.pregunta = pregunta;
        this.tematica = tematica;
        this.opcionCorrecta = opcionCorrecta;
        this.tipo = tipo;
    }

    @Override
    public int validarSeleccion(List<Number> seleccion) {
        Boolean acierta = opcionCorrecta.equals(seleccion.get(0));
        return tipo.devolverPuntaje(acierta);
    }
}
