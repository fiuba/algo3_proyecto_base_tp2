package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrdenDeRonda {
    private Integer turno = 1;
    private List<Jugador> jugadores;

    public OrdenDeRonda(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }


    public Jugador obtenerJugadorActual(){
        return jugadores.get(turno-1);
    }
    public Integer obtenerTurno(){
        return turno;
    }
    public void avanzarTurno(){
        if (!(turno > jugadores.size())) {
            turno++;
        }
    }
    public boolean rondaFinalizada(){
        if(turno > jugadores.size()) return true;
        return false;
    }
}
