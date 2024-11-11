package edu.fiuba.algo3.modelo;

public class Diamante implements Palo {

    public boolean sonDelMismoPalo(Poker carta){
        return carta.getPalo() instanceof Diamante;
    }
}
