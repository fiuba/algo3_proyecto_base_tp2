package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVFPenalidad implements Pregunta{
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;
    private String tematica;
    private String textoRespuesta;

    public PreguntaVFPenalidad(String pregunta, String tematica, String textoRespuesta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
        this.tematica = tematica;
        this.textoRespuesta = textoRespuesta;
    }

    @Override
    public String getPregunta() {
        return "";
    }

    @Override
    public List<Opcion> getOpciones() {
        return List.of();
    }

    public Puntaje responder(Respuesta... respuesta) {
        Puntaje acumulador = new Puntaje(0);

        acumulador.sumar(opcionCorrecta.puntuar(respuesta[0]));
        acumulador.sumar(opcionIncorrecta.puntuar(respuesta[0]));

        return acumulador;
    }

    public String getTematica() {return this.tematica;}
    public String getTextoRespuesta() {return this.textoRespuesta;}
}
