package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaGC implements Pregunta {
    private String pregunta;
    private Grupo unGrupo;
    private Grupo otroGrupo;
    private String tematica;
    private String textoRespuesta;

    public PreguntaGC(String pregunta, String tematica, String textoRespuesta,Grupo unGrupo, Grupo otroGrupo) {
        this.pregunta = pregunta;
        this.unGrupo = unGrupo;
        this.otroGrupo = otroGrupo;
        this.tematica = tematica;
        this.textoRespuesta = textoRespuesta;
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

    public String getTematica() {return this.tematica;}
    public String getTextoRespuesta() {return this.textoRespuesta;}
}
