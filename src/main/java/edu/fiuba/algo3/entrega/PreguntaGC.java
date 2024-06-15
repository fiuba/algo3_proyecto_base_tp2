package edu.fiuba.algo3.entrega;

import java.util.List;

public class PreguntaGC implements Pregunta {
    private String pregunta;
    private Grupo unGrupo;
    private Grupo otroGrupo;

    public PreguntaGC(String pregunta, Grupo unGrupo, Grupo otroGrupo) {
        this.pregunta = pregunta;
        this.unGrupo = unGrupo;
        this.otroGrupo = otroGrupo;
    }

    public Puntaje responder(Respuesta respuesta) {
        return unGrupo.puntuar(respuesta);
    }

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<Opcion> getOpciones() {
        return List.of();
    }
}
