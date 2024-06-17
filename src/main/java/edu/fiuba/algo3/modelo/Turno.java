package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    private Pregunta pregunta;
    private List<Puntaje> puntajes;
    private List<ModificadorGlobal> modificadoresGlobales;

    public Turno(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.puntajes = new ArrayList<Puntaje>();
        this.modificadoresGlobales = new ArrayList<ModificadorGlobal>();
    }

    public void jugar(Jugador j, ModificadorIndividual modInd, ModificadorGlobal modGlob, Respuesta... respuestas) {

        Puntaje puntos = pregunta.responder(respuestas);

        puntos.establecerJugador(j);

        puntos.agregarModificador(modInd);

        j.gastar(modInd);

        modificadoresGlobales.add(modGlob);

        puntajes.add(puntos);
    }

    public void terminar() {

        modificadoresGlobales.forEach(m -> m.aplicar(puntajes));

        puntajes.forEach(Puntaje::actualizarPuntajeDelJugador);
    }

    public Pregunta getPregunta() {
        return pregunta;
    }
}
