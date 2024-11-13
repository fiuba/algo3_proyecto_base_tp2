package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;


public abstract class ManoDePoker {
    protected Puntaje puntaje;

    public int jugar(ArrayList<Carta> cartas){
        Puntaje sumaDePuntajes = new Puntaje(0,1);
        for (Carta carta : cartas){
            Puntaje puntajeDeCarta = carta.calcularPuntaje();
            sumaDePuntajes.sumarConPuntaje(puntajeDeCarta);
        }
        return this.puntaje.calcularPuntaje();
    }


}

