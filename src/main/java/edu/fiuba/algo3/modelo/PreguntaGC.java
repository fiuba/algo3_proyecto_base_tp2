package edu.fiuba.algo3.modelo;

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

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<Opcion> getOpciones() {
        return List.of();
    }

    @Override
    public Puntaje responder(Respuesta... respuestas) {
        Puntaje acumuluador = new Puntaje();
        acumuluador.sumar(unGrupo.puntuar(respuestas));
        acumuluador.sumar(otroGrupo.puntuar(respuestas));
        return acumuluador;
    }
}
