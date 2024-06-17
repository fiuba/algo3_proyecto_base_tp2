package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgoHoot {

    private static AlgoHoot instancia;

    private GestorDeTurnos gestorDeTurnos;

    private List<Jugador> jugadores;

    private AlgoHoot() throws ArchivoInexistente {
        gestorDeTurnos = new GestorDeTurnos();

        jugadores = new LinkedList<Jugador>();
    }

    public static AlgoHoot getInstancia() throws ArchivoInexistente {
        if (instancia == null) {
            instancia = new AlgoHoot();
        }
        return instancia;
    }



    public void comenzarNuevoTurno(){
        gestorDeTurnos.comenzarNuevoTurno();
    }

    public void jugarTurno(Jugador j, ModificadorIndividual mi, ModificadorGlobal mg, Respuesta... respuestas){
        gestorDeTurnos.jugarTurnoActual(j, mi, mg, respuestas);
    }

    public void terminarTurno(){
        gestorDeTurnos.terminarTurnoActual();
    }


    public Pregunta obtenerPreguntaActual(){
        return gestorDeTurnos.obtenerPreguntaTurnoActual();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> obtenerJugadores(){
        return jugadores;
    }
}
