package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.manoDe5.ManoDe5;

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
        cartasSeleccionadas.agregarCarta(cartaAElegir);
    }

    public void deseleccionarCarta(Carta carta) {
        Carta cartaADeseleccionada = this.mano.obtenerCarta(carta);
        cartasSeleccionadas.quitarCarta(cartaADeseleccionada);
    }

    public int jugarMano() {
        return cartasSeleccionadas.jugarMano();
    }

    public int obtenerCantidadDeCartas() {
        return this.mano.obtenerCantidadDeCartas();
    }
}


