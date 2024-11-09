package edu.fiuba.algo3.modelo.mano;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mazo.CartasInsuficientesException;

import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;
    private int maximo;

    public Mano() {
        this.cartas = new ArrayList<Carta>();
        this.maximo = 8;
    }

    public void agregarCarta(Carta carta) {
        if (this.maximo == this.cartas.size()) {
            throw new ManoLlenaException();
        }
        this.cartas.add(carta);
    }

    public void quitarCarta(Carta carta) {
        Carta cartaABorrar = this.obtenerCarta(carta);
        this.cartas.remove(cartaABorrar);
    }

    public int obtenerCantidadDeCartas() {
        return this.cartas.size();
    }

    public Carta obtenerCarta(Carta cartaBuscada) {
        for (Carta carta: this.cartas) {
            if (carta.sos(cartaBuscada)) {
                return carta;
            }
        }
        throw new CartaNoEnManoException();
    }
}
