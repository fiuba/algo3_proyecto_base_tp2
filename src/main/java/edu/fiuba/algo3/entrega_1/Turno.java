package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    private Pregunta pregunta;
    private List<Respuesta> respuestas;

    public Turno(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<Respuesta>();
    }

    public void jugarTurno(List<Jugador> listaJugadores) {
        for (Jugador jugador : listaJugadores) {
            List<Number> seleccion = jugador.obtenerJugada();

            int puntaje = pregunta.validarSeleccion(seleccion);

            Respuesta respuesta = new Respuesta(jugador, puntaje);
            respuestas.add(respuesta);
        }

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarPuntajeDelJugador();
        }
    }
}
