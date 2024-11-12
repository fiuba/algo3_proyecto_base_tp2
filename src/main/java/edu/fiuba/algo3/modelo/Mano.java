package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mano {
    ArrayList<Carta> cartas;
    int maximoCartas = 8;

    Mano() {
        cartas = new ArrayList<>();
    }

    public void repartirUsando(Mazo mazo) {
        while (cartas.size() < maximoCartas) {
            cartas.add(mazo.tomarCarta());
        }
    }

    public Puntaje calcularPuntaje(ArrayList<Poker> cartasSeleccionadas) {
        return new Puntaje(cartasSeleccionadas);
    }

    public int tamanio() {
        return cartas.size();
    }
}
