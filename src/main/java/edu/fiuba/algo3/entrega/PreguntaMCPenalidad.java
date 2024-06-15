package edu.fiuba.algo3.entrega;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PreguntaMCPenalidad implements Pregunta{
    private String pregunta;
    private List<Opcion> opciones;

    public PreguntaMCPenalidad(String pregunta, Opcion... opciones) {
        this.pregunta = pregunta;
        this.opciones = new ArrayList<Opcion>();
        Collections.addAll(this.opciones, opciones);
    }

    public Puntaje responder(Respuesta... respuestas) {
        return Arrays.stream(respuestas)
                .flatMap(r -> opciones.stream().map(op -> op.puntuar(r)))
                .reduce(new Puntaje(0), (p, valor) -> {
                    p.sumar(valor);
                    return p;
                });
    }

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<Opcion> getOpciones() {
        return this.opciones;
    }
}
