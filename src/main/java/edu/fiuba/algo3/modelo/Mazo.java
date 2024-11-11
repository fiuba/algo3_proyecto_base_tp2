package edu.fiuba.algo3.modelo;

public class Mazo {
    public void rellenarMano(Mano mano) {
        while (!mano.estaLlena()) {
            // seleccionar carta al azar
            Carta carta = new Poker(1, "Q", 10, new Diamante());
            mano.agregarCarta(carta);
        }
    }
}
