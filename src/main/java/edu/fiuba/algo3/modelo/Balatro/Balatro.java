package edu.fiuba.algo3.modelo.Balatro;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ronda.Ronda;

import java.util.ArrayList;

public class Balatro {
    private static Balatro instancia;
    private boolean rondaGanada = true;
    private ArrayList<Ronda> rondas;
    private Mazo mazoDeCartas;
    private Jugador jugador;

    private Balatro(ArrayList<Ronda> rondas, Mazo mazoDeCartas, String jugador) {
        this.rondas = rondas;
        this.mazoDeCartas = mazoDeCartas;
        Jugador player = Jugador.CrearJugador(jugador);
        this.jugador = player;

    }

    public static Balatro inicializarBalatro(ArrayList<Ronda> rondas, Mazo mazoDeCartas, String jugador) {
        if (instancia != null) {
            throw new IllegalStateException("La instancia de Balatro ya ha sido inicializada.");
        }
        if ( rondas == null)
            throw new IllegalStateException("No hay datos de rondas.");
        instancia = new Balatro(rondas, mazoDeCartas, jugador);
        return null;
    }

    public static Balatro getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("La instancia de Balatro aún no ha sido inicializada.");
        }
        return instancia;
    }

    public Ronda jugar() {
        try {
            if (!verificarRondaAnteriorGanada()) {
                throw new IllegalStateException("La ronda anterior no fue ganada. No se puede jugar la siguiente ronda.");
            }
            if (this.rondas.isEmpty()) {
                throw new RondasAgotadasException("No hay más rondas disponibles para jugar.");
            }
            Ronda rondaActual = rondas.get(0);
            rondaActual.empezarRonda(jugador, mazoDeCartas);
            this.rondas.remove(rondaActual);
            return rondaActual;
        } catch (RondasAgotadasException | IllegalStateException e) {
            System.err.println("Error al intentar jugar: " + e.getMessage());
            return null;
        }
    }

    private boolean verificarRondaAnteriorGanada() {
        return this.rondaGanada;
    }

    public boolean juegoTerminado() {
        return this.rondas.isEmpty();
    }

}

