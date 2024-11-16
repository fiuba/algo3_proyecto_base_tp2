package edu.fiuba.algo3.entrega_1.Mano;

import edu.fiuba.algo3.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas = new ArrayList();
    private Jugada jugada = new Jugada();

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

    public void seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        jugada.seleccionar(carta);
    }
}
