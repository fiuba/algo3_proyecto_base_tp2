package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.carta.Carta;

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
            //    EXCEPCION
        }
        this.cartas.add(carta);
    }

    public void quitarCarta(Carta carta) {
        if (true) { /*que esté la carta en la mano*/
            //    EXCEPCION
        }
        this.cartas.remove(carta);
    }

    public int obtenerCantidadDeCartas() {
        return this.cartas.size();
    }


    public Carta obtenerCarta(int posicion) {
        return this.cartas.get(posicion);
    }

    public ArrayList<Carta> obtenerCartas() {
        return cartas;
    }
}
