package edu.fiuba.algo3.modelo;

public class Trebol implements Palo{

    public boolean sonDelMismoPalo(Poker carta){
        return carta.getPalo() instanceof Trebol;
    }
}
