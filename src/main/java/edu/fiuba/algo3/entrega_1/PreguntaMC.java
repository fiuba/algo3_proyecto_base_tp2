package edu.fiuba.algo3.entrega_1;

import java.util.*;

public class PreguntaMC {
    private String pregunta;
    private List<Opcion> opciones;

    public PreguntaMC(String pregunta, Opcion... opciones) {
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

        // Si hay alguna opcion correcta sin seleccionar -> return 0

        Optional<Opcion> opcionSinSeleccionar = opciones.stream()
                .filter(op -> op instanceof OpcionCorrecta)
                .filter(op -> Arrays.stream(respuestas)
                        .noneMatch(op::equals))
                .findAny();

        if (opcionSinSeleccionar.isPresent()) {
            return new Puntaje(0);
        }

        return new Puntaje(1);
    }
}
