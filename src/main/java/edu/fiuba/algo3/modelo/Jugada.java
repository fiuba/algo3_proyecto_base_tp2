package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Jugada {
    ArrayList<Poker> cartas;
    int multiplicadorBase;
    int valorBase;

    public Jugada(ArrayList<Poker> cartas) {
        this.cartas = cartas;
    }

    public void modificarPuntaje(Puntaje puntaje) {
        puntaje.sumarMultiplicador(multiplicadorBase);
        puntaje.sumarValorBase(valorBase);

        for (Poker carta : cartas) {
            carta.modificarPuntaje(puntaje);
        }
    }
}
