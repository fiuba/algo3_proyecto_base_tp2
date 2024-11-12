package edu.fiuba.algo3.modelo;

public class Jugador {
    Mazo mazo;
    Mano mano;
    Puntaje puntaje;

    public Jugador() {
        mazo = new Mazo();
        mano = new Mano();
        puntaje = new Puntaje(0, 0);
    }

    public void repartirMano()  {
        mano.repartirUsando(mazo);
    }

    public int jugarMano() {
        Jugada jugada = mano.jugar();
        jugada.modificarPuntaje(puntaje);
        mano.modificarPuntaje(puntaje);
        // Pasivos
        int puntajeFinal = puntaje.calcularTotal();
        puntaje = new Puntaje(0, 0);
        return puntajeFinal;
    }
}
