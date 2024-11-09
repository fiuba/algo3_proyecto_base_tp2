package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.carta.*;

import java.util.ArrayList;


public class Mazo {
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasDescartadas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        this.cartasDescartadas = new ArrayList<Carta>();
        for(int i = 1; i <= 52; i++) {
            this.cartas.add(new Carta(12, new Corazon()));
        }
    }

    public void repartirCartas(int cantidad, Mano mano) {
        if (cantidad > this.cartas.size()) {
            // EXCEPCION;
        }
        for(int i = 1; i <= cantidad; i++) {
            int indice = (int) (Math.random() * this.cartas.size());
            Carta carta = this.cartas.remove(indice);
            mano.agregarCarta(carta);
            this.cartasDescartadas.add(carta);
        }
    }

    public void mezclar() {
        this.cartas.addAll(this.cartasDescartadas);
        this.cartasDescartadas.clear();
    }
}
