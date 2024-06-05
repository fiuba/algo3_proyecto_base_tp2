package edu.fiuba.algo3.entrega_1;

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

        acumulador.sumar(opcionCorrecta.compararseCon(respuesta));
        acumulador.sumar(opcionIncorrecta.compararseCon(respuesta));

        return acumulador;
    }
}
