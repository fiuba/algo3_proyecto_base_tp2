package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;

import java.util.ArrayList;
import java.util.List;

public class GestorDePreguntas {

    private List<Pregunta> preguntas;
    private Integer contador = 0;

    public GestorDePreguntas() throws ArchivoInexistente {
        Lector lector = new Lector();

        this.preguntas = lector.cargarPreguntas();
    }

    public Pregunta obtenerSiguientePregunta() {
        Pregunta siguientePregunta = preguntas.get(contador);
        contador++;
        return siguientePregunta;
    }
}
