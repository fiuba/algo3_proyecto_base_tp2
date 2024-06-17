package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVF implements Pregunta{
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;
    private String tematica;
    private String textoRespuesta;

    public PreguntaVF(String pregunta, String tematica, String textoRespuesta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
        this.tematica = tematica;
        this.textoRespuesta = textoRespuesta;
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

    public String getTematica() {return this.tematica;}
    public String getTextoRespuesta() {return this.textoRespuesta;}
}