package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVFPenalidad implements Pregunta{
    private String pregunta;
    private OpcionCorrecta opcionCorrecta;
    private OpcionIncorrecta opcionIncorrecta;

    public PreguntaVFPenalidad(String pregunta, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta) {
        this.pregunta = pregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
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
}
