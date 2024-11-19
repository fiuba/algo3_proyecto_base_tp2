package edu.fiuba.algo3.entrega_1.Mano;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Mano {
    private Proveedor proveedor;
    private List<Carta> cartas = new ArrayList();
    private Jugada jugada = new Jugada();

    public Mano(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.cartas = proveedor.generarCartas();
    }


    public boolean esManoCompleta() {
        return cartas.size() == 8;
    }

    public List<Carta> jugarCartas(List<Carta> cartasRecibidas) {;
        cartas.removeAll(cartasRecibidas);
        return cartasRecibidas;
    }

    // posible solucion
    public void ordenarMano(){
        OrdenadorDeCartas.ordenarCartas(this.cartas);
    }


    public List<Carta> verCartasEnMano(){
        return cartas;
    }

    public void seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        jugada.seleccionar(carta);
    }
}

 /*public void ordenarMano(List<Carta> cartasRecibidas){
       //Collections.sort(cartasRecibidas, (Carta a, Carta b) -> Integer.compare(b.getValor(), a.getValor()));
        this.cartas.sort(Comparator.comparingInt(Carta::getValor).reversed());
    }*/