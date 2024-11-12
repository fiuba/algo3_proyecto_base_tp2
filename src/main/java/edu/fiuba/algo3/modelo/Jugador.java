package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.naipes.carta.Carta;
import edu.fiuba.algo3.modelo.naipes.Mano;
import edu.fiuba.algo3.modelo.naipes.ManoDe5;

public class Jugador {
    private Mano mano;
    private ManoDe5 cartasSeleccionadas;

    public Jugador() {
        this.cartasSeleccionadas = new ManoDe5();
    }

    public void establecerMano(Mano mano) {
        this.mano = mano;
    }

    public void elegirCarta(Carta carta) {
        Carta cartaAElegir = this.mano.obtenerCarta(carta);
        this.cartasSeleccionadas.agregarCarta(cartaAElegir);
    }

    public void deseleccionarCarta(Carta carta) {
        Carta cartaADeseleccionada = this.mano.obtenerCarta(carta);
        this.cartasSeleccionadas.quitarCarta(cartaADeseleccionada);
    }

    public int jugarMano() {
        int valor = this.cartasSeleccionadas.jugarMano();
        this.cartasSeleccionadas = new ManoDe5();
        return valor;
    }

    public int obtenerCantidadDeCartas() {
        return this.mano.obtenerCantidadDeCartas();
    }

    public int obtenerCantidadDeCartasSeleccionadas() {
        return this.cartasSeleccionadas.obtenerCantidadDeCartas();
    }
}


