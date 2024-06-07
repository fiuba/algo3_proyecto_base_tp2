package edu.fiuba.algo3.entrega;

public class PreguntaVF {
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;

    public PreguntaVF(String pregunta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
    }

    public Puntaje responder(Respuesta respuesta) {
        return opcionCorrecta.puntuar(respuesta);
    }
}