package edu.fiuba.algo3.entrega;

public class PreguntaOC {
    private String pregunta;
    private Orden ordenCorrecto;

    public PreguntaOC(String pregunta, Orden orden) {
        this.pregunta = pregunta;
        this.ordenCorrecto = orden;
    }

    public Puntaje responder(Respuesta respuesta) {

        return ordenCorrecto.puntuar(respuesta);

    }
}
