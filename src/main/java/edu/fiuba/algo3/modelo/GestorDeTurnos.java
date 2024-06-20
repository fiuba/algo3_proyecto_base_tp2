package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.modelo.excepciones.TurnoNoIniciado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GestorDeTurnos {
    private LinkedList<Turno> turnos;
    private GestorDePreguntas gestorDePreguntas;
    private List<Jugador> jugadores;

    public GestorDeTurnos() throws ArchivoInexistente {
        this.turnos = new LinkedList<>();
        gestorDePreguntas = new GestorDePreguntas();
        jugadores = new LinkedList<Jugador>();
    }


    public void comenzarNuevoTurno() {
        Pregunta p = gestorDePreguntas.obtenerSiguientePregunta();
        Turno nuevoTurno = new Turno(p);
        turnos.add(nuevoTurno);
    }

    public Pregunta obtenerPreguntaTurnoActual(){
        if(turnos.size() == 0){
            comenzarNuevoTurno();
        }
        return turnos.getLast().getPregunta();
    }

    public void jugarTurnoActual(Jugador j, ModificadorIndividual mi, ModificadorGlobal mg, Respuesta... respuestas) {
        Turno turno = turnos.getLast();
        turno.jugar(j, mi, mg, respuestas);
    }

    public void terminarTurnoActual() {
        Turno turno = turnos.getLast();
        turno.terminar();
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
