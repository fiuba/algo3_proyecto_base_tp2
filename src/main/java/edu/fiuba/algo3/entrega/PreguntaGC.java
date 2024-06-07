package edu.fiuba.algo3.entrega;

public class PreguntaGC {
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
}
