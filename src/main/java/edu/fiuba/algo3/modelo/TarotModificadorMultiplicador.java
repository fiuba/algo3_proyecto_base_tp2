package edu.fiuba.algo3.modelo;

public class TarotModificadorMultiplicador extends Tarot {

    @Override
    public void modificar(Poker carta) {
        carta.setMultiplicador(6);
    }
}
