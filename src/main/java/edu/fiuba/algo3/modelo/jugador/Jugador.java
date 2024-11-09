package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import java.util.ArrayList;

public class Jugador {
    private Puntaje puntaje;
    public Mano mano;
    private ArrayList<Carta> cartasSeleccionadas;

    public Jugador() {
        this.puntaje = new Puntaje(0, 1);
        this.cartasSeleccionadas = new ArrayList<Carta>();
    }

    public Puntaje obtenerPuntaje() {
        return puntaje;
    }

    public Mano obtenerMano() {
        return mano;
    }

    public void establecerMano(Mano mano) {
        this.mano = mano;
    }

    public void elegirCarta(Carta carta) {
        if (cartasSeleccionadas.size() == 5) {
            throw new MaximoCartasSeleccionadasException();
        }
        Carta cartaSeleccionada = this.mano.obtenerCarta(carta);
        if (!this.cartasSeleccionadas.contains(cartaSeleccionada)) {
            this.cartasSeleccionadas.add(cartaSeleccionada);
        }
    }

    public void deseleccionarCarta(Carta carta) {
        Carta cartaSeleccionada = this.mano.obtenerCarta(carta);
        this.cartasSeleccionadas.remove(cartaSeleccionada);
    }

    public int jugarMano() {
        return 10;
    }

    public int obtenerCantidadDeCartas() {
        return this.mano.obtenerCantidadDeCartas();
    }
}


