package edu.fiuba.algo3.entrega;

import java.util.Arrays;

public class Anulador {
    private Jugador jugador;
    public Anulador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void anular(Puntaje... puntos) {
        Arrays.stream(puntos)
                .filter(p -> !p.perteneceA(jugador))
                .forEach(p -> p.agregarModificador(new ModificadorNulo()));
    }
}
