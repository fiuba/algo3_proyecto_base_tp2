package edu.fiuba.algo3.modelo.naipes;
import edu.fiuba.algo3.modelo.naipes.carta.Carta;

import java.util.ArrayList;

public class Mano {
    protected ArrayList<Carta> cartas;
    protected int maxCartas;

    public Mano(int cantidadDeCartas) {
        this.cartas = new ArrayList<Carta>();
        this.maxCartas = cantidadDeCartas;
    }

    public void agregarCarta(Carta carta) {
        if (this.maxCartas == this.cartas.size()) {
            throw new ManoLlenaException();
        }
        this.cartas.add(carta);
    }

    public void quitarCarta(Carta carta) {
        Carta cartaAQuitar = obtenerCarta(carta);
        this.cartas.remove(cartaAQuitar);
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
