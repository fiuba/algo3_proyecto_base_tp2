package edu.fiuba.algo3.entrega;

public class PreguntaVFPenalidad {
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;

    public PreguntaVFPenalidad(String pregunta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
    }

    public Puntaje responder(Respuesta respuesta) {
        Puntaje acumulador = new Puntaje(0);

        acumulador.sumar(opcionCorrecta.puntuar(respuesta));
        acumulador.sumar(opcionIncorrecta.puntuar(respuesta));

        return acumulador;
    }
}
