package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaOC implements Pregunta{
    private String pregunta;
    private Opcion[] opciones;
    private Orden ordenCorrecto;

    public PreguntaOC(String pregunta, Opcion... opciones) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.ordenCorrecto = new Orden(opciones);
    }

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<Opcion> getOpciones() {
        return null;
    }

    @Override
    public Puntaje responder(Respuesta... respuestas) {
        return ordenCorrecto.puntuar(respuestas);
    }
}
