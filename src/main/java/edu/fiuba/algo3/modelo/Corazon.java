package edu.fiuba.algo3.modelo;

public class Corazon implements Palo{

    public boolean sonDelMismoPalo(Poker carta){
        return carta.getPalo() instanceof Corazon;
    }
}
