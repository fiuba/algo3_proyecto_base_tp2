package edu.fiuba.algo3.entrega;

import java.util.List;

public interface Pregunta {
    public String getPregunta();
    public List<Opcion> getOpciones();
    public Puntaje responder(Respuesta... respuestas);
}
