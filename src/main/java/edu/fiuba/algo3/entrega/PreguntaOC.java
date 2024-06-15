package edu.fiuba.algo3.entrega;

import java.util.List;

public class PreguntaOC implements Pregunta{
    private String pregunta;
    private Orden ordenCorrecto;

    public PreguntaOC(String pregunta, Orden orden) {
        this.pregunta = pregunta;
        this.ordenCorrecto = orden;
    }

    public Puntaje responder(Respuesta respuesta) {

        return ordenCorrecto.puntuar(respuesta);

    }

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<Opcion> getOpciones() {
        return null;
    }
}
