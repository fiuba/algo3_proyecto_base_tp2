package edu.fiuba.algo3.entrega_1.Mano;

import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas = new ArrayList();

    public Mano(List<Carta> cartas){
        this.cartas = cartas;
    }


    public boolean esManoCompleta() {
        return cartas.size() == 8;
    }

    public List<Carta> jugarCartas(List<Carta> cartasRecibidas) {;
        cartas.removeAll(cartasRecibidas);
        return cartasRecibidas;
    }
}
