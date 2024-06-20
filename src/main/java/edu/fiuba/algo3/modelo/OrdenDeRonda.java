package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrdenDeRonda {
    private Integer turno = 0;
    private List<Jugador> jugadores;

    public OrdenDeRonda(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }


    public Jugador obtenerJugadorActual(){
        return jugadores.get(turno);
    }
    public Integer obtenerTurno(){
        return turno;
    }
    public void avanzarTurno(){
        if (!this.rondaFinalizada()) {
            turno++;
        }
    }
    public boolean rondaFinalizada(){
        if(turno == jugadores.size()) return true;
        return false;
    }
}
