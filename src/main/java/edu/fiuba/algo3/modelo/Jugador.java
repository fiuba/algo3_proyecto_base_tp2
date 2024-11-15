package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugada.Jugada;

public class Jugador {
    Mazo mazo;
    Mano mano;
    Comodines comodines;
    Puntaje puntaje;

    public Jugador(Mazo mazo) {
        this.mazo = mazo;
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
        comodines.modificarPuntaje(puntaje);
        int puntajeFinal = puntaje.calcularTotal();
        puntaje = new Puntaje(0, 0);
        return puntajeFinal;
    }

    public void seleccionarCarta(Poker carta) {
        mano.seleccionarCarta(carta);
    }

    public void agregarComodin(Comodin comodin) {
        comodines.agregar(comodin);
    }
}
