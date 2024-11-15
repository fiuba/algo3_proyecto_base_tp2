package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    ArrayList<Poker> cartas;

    public Mazo(ArrayList<Poker> cartas) {
        this.cartas = cartas;
        Collections.shuffle(this.cartas);
    }

    public Poker tomarCarta() {
        if (cartas.isEmpty()) {
            throw new SinCartasError("Mazo está vacío");
        }
        return cartas.remove(0);
    }
}
