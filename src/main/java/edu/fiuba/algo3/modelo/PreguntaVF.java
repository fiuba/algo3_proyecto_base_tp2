package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVF implements Pregunta{
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;

    public PreguntaVF(String pregunta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
    }

    public Puntaje responder(Respuesta... respuesta) {
        return opcionCorrecta.puntuar(respuesta[0]);
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