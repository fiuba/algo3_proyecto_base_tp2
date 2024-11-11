package edu.fiuba.algo3.modelo;

public class TarotModificadorPuntos extends Tarot{
    @Override
    public void modificar(Poker carta) {
        carta.setValorNumerico(10);
    }
}
