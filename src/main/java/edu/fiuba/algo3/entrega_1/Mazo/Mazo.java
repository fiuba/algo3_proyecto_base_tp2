package edu.fiuba.algo3.entrega_1.Mazo;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import edu.fiuba.algo3.entrega_1.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;


public class Mazo {
    final int TAMANIOMANO = 8;
    private List<Carta> cartas;

    public Mazo(Proveedor proveedor){
        List<Carta> cartas = proveedor.generarCartas();

    }
    public void mezclar(){
        Collections.shuffle(cartas);
    }

    public List<Carta> repartir(){

        List<Carta> cartasJugador = new ArrayList<>();

        for(int i = 0; i < (TAMANIOMANO -1 ); i++){
            cartasJugador.add(cartas.get(i));
        }
        cartas.subList(0,TAMANIOMANO).clear();

        return cartasJugador;
    }
    private List<Carta> repartirConUnaCantidad(List<Carta> cartasRecibidas){
        int cantidadDeCartas;
        this.cartas.addAll(cartasRecibidas);
        this.mezclar();

        cantidadDeCartas = TAMANIOMANO - cartasRecibidas.size();

        if(cantidadDeCartas > this.cartas.size()){
            // excepcion, preguntar como hacerlo.
        }
        List<Carta> manoJugador = new ArrayList<>(this.cartas.subList(0, cantidadDeCartas));

        return manoJugador;
    }

    public List<Carta> reponer(List<Carta> cartas) {
        return repartirConUnaCantidad(cartas);
    }
}
