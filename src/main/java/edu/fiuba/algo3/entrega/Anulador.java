package edu.fiuba.algo3.entrega;

import java.util.Arrays;
import java.util.List;

public class Anulador implements ModificadorGlobal{
    private Jugador jugador;
    public Anulador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void aplicar(List<Puntaje> puntajes) {
        puntajes.stream()
                .filter(p -> !p.perteneceA(jugador))
                .forEach(p -> p.agregarModificador(new ModificadorNulo()));
    }
}
