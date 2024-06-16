package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Puntaje {
    private int puntajeBase;
    private Jugador jugador;
    private List<ModificadorIndividual> modificadores;

    public Puntaje() {
        this.puntajeBase = 0;
    }
    public Puntaje(int puntajeInicial) {
        this.puntajeBase = puntajeInicial;
        this.modificadores = new ArrayList<ModificadorIndividual>();
        this.modificadores.add(new ModificadorBase());
    }

    public void sumar(Puntaje otroPuntaje) {
        this.puntajeBase += otroPuntaje.puntajeBase;
        this.modificadores = new ArrayList<ModificadorIndividual>();
        this.modificadores.add(new ModificadorBase());
    }

    public void establecerJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void agregarModificador(ModificadorIndividual mod) {
        this.modificadores.add(mod);
    }

    public int obtenerPuntos() {
        return this.modificadores.stream()
                .reduce(puntajeBase,
                        (puntaje, mod) -> mod.modificar(puntaje),
                        (puntaje1, puntaje2) -> puntaje2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puntaje otroPuntaje = (Puntaje) o;

        return (puntajeBase == otroPuntaje.puntajeBase);
    }

    public boolean perteneceA(Jugador j){
        return this.jugador.equals(j);
    }

    public void actualizarPuntajeDelJugador() {
        jugador.sumarPuntos( this.obtenerPuntos() );
    }
}