package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;


public abstract class ManoDePoker {
    protected Puntaje puntaje;

    public int jugar(ArrayList<Carta> cartas){
        Puntaje sumaDePuntajes = this.puntaje;
        for (Carta carta : cartas){
            Puntaje puntajeDeCarta = carta.calcularPuntaje();
            sumaDePuntajes.sumarConPuntaje(puntajeDeCarta);
        }
        return this.puntaje.calcularPuntaje();
    }

    public Puntaje calcularPuntaje() {
        return this.puntaje;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true; // Si ambos objetos son el mismo, son iguales
        }
        if (o == null || getClass() != o.getClass()) {
            return false; // Si el objeto es nulo o no es del mismo tipo, no son iguales
        }
        return true; // Si son del mismo tipo, los consideramos iguales
    }

}

