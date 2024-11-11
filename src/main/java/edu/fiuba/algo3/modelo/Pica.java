package edu.fiuba.algo3.modelo;

public class Pica implements Palo{

    public boolean sonDelMismoPalo(Poker carta){
        return carta.getPalo() instanceof Pica;
    }
}