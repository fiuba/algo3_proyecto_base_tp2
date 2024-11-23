package edu.fiuba.algo3.modelo.Mazo;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import edu.fiuba.algo3.modelo.Prooveedor.Proveedor;
import edu.fiuba.algo3.modelo.carta.Carta;


public class Mazo implements Proveedor{
    final int TAMANIOMANO = 8;
    private List<Carta> cartas;

    public Mazo(Proveedor proveedor){
        this.cartas = proveedor.generarCartas();
    }
    public void mezclar(){
        Collections.shuffle(this.cartas);
    }

    public List<Carta> generarCartas(){
        List<Carta> cartasJugador = new ArrayList<>();

        for(int i = 0; i < (TAMANIOMANO); i++){
            cartasJugador.add(cartas.get(i));
        }
        cartas.subList(0,TAMANIOMANO).clear();  //retorna una lista de carta de un tamaño pedido

        return cartasJugador;
    }
    public List<Carta> repartirCartas(){
        this.mezclar();
        return this.generarCartas();  //la utiliza ronda cuando crea la mano
    }
    private List<Carta> repartirConUnaCantidad(List<Carta> cartasRecibidas){
        int cantidadDeCartas;
        this.cartas.addAll(cartasRecibidas);
        this.mezclar();

        cantidadDeCartas = TAMANIOMANO - cartasRecibidas.size();

        if(cantidadDeCartas > this.cartas.size()){
            throw new TamanioMazoInsuficiente();
        }
        List<Carta> manoJugador = new ArrayList<>(this.cartas.subList(0, cantidadDeCartas));
        return manoJugador;
    }



    public List<Carta> reponer(List<Carta> cartas) {
        return repartirConUnaCantidad(cartas);
    }

    public int obtenerCantidadDeCartas() {
        return this.cartas.size();
    }
}