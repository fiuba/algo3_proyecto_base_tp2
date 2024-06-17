package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.modelo.excepciones.TurnoNoIniciado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GestorDeTurnos {
    private LinkedList<Turno> turnos;
    private GestorDePreguntas gestorDePreguntas;

    public GestorDeTurnos() throws ArchivoInexistente {
        this.turnos = new LinkedList<>();
        gestorDePreguntas = new GestorDePreguntas();
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

    public void jugarTurnoActual(Jugador j, ModificadorIndividual mi, ModificadorGlobal mg, Respuesta res) {
        Turno turno = turnos.getLast();
        turno.jugar(j, mi, mg, res);
    }

    public void terminarTurnoActual() {
        Turno turno = turnos.getLast();
        turno.terminar();
    }
}
