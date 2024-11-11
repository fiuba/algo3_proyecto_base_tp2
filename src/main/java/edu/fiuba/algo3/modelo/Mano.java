package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mano {
    ArrayList<Carta> cartas;
    int maximoCartas = 8;

    Mano() {
        cartas = new ArrayList<>();
    }

    public boolean estaLlena() {
        return tamanio() == maximoCartas;
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int tamanio() {
        return cartas.size();
    }

    public Puntaje calcularPuntaje(ArrayList<Carta> cartasSeleccionadas) {
        return new Puntaje(cartasSeleccionadas);
    }
}
