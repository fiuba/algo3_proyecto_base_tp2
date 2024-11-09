package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.carta.Carta;
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

    public void elegirCarta(int posicion) {
        if (posicion < 0 && posicion > 8) {
            //EXCEPCION
        }
        if (cartasSeleccionadas.size() < 5) {
            //EXCEPCION
        }
        Carta cartaSeleccionada = this.mano.obtenerCarta(posicion);
        this.cartasSeleccionadas.add(cartaSeleccionada);
    }

    public void deseleccionarCarta(int posicion) {
        if (posicion < 0 && posicion > 8) {
            //EXCEPCION
        }
        Carta cartaSeleccionada = this.mano.obtenerCarta(posicion);
        this.cartasSeleccionadas.remove(cartaSeleccionada);
    }

    public int tirarMano() {
        return 5;
    }

    public int obtenerCantidadDeCartas() {
        return this.mano.obtenerCantidadDeCartas();
    }
}


