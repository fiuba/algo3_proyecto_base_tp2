package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Comodines {
    ArrayList<Comodin> cartas;

    public Comodines(ArrayList<Comodin> cartas) {
        this.cartas = cartas;
    }

    public void modificarPuntaje(Puntaje puntaje) {
        for (Comodin comodin : cartas) {
            comodin.modificarPuntaje(puntaje);
        }
    }

    public void agregar(Comodin comodin) {
        // Agregar límite (creo que 5)
        cartas.add(comodin);
    }
}
