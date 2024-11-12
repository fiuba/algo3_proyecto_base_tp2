package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;


public abstract class ManoDePoker {
    protected Puntaje puntaje;

    public int jugar(ArrayList<Carta> cartas){
        int sumaDeLosValores = 0;
        for (Carta carta : cartas){
            sumaDeLosValores += carta.getValor().getValor();
        }
        return this.puntaje.calcularPuntaje(sumaDeLosValores);
    }
}

