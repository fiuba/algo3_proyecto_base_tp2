package edu.fiuba.algo3.modelo.jugada;

import edu.fiuba.algo3.modelo.Poker;
import edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;

public abstract class Jugada {
    ArrayList<Poker> cartas;
    int multiplicadorBase;
    int valorBase;

    public static boolean verificar(ArrayList<Poker> cartas) {
        return false;
    }

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
