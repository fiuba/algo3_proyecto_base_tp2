package edu.fiuba.algo3.modelo;

public class Corazon {
    public boolean sonDelMismoPalo(Poker carta){
        return this == carta.getPalo();
    }
}
