package edu.fiuba.algo3.entrega;

import java.util.*;

public class PreguntaMCParcial implements Pregunta {
    private String pregunta;
    private List<Opcion> opciones;

    public PreguntaMCParcial(String pregunta, Opcion... opciones) {
        this.pregunta = pregunta;
        this.opciones = new ArrayList<Opcion>();
        Collections.addAll(this.opciones, opciones);
    }

    public Puntaje responder(Respuesta... respuestas) {

        // Si hay una respuesta incorrecta -> return 0

        Optional<Opcion> opcionIncorrectaSeleccionada = Arrays.stream(respuestas)
                .flatMap(r -> opciones.stream()
                        .filter(op -> op instanceof OpcionIncorrecta && op.equals(r)))
                .findAny();

        if (opcionIncorrectaSeleccionada.isPresent()) {
            return new Puntaje(0);
        }

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
