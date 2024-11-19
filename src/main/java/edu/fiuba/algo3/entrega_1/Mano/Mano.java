package edu.fiuba.algo3.entrega_1.Mano;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.entrega_1.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {
    private Proveedor proveedor;
    private List<Carta> cartas = new ArrayList();
    private Jugada jugada = new Jugada();
    private int descartes;
    //private MazoDeComodines comodines;

    public Mano(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.cartas = proveedor.generarCartas();
        this.ordenarMano();
        this.descartes = 3;
        //this.comodines = new MazoDeComodines();

    }

    public Mano(Proveedor proveedor,int descartes, MazoDeComodines comodines) {
        this.proveedor = proveedor;
        this.cartas = proveedor.generarCartas();
        this.descartes = descartes;         //constructor para poder elegir la cantidad de descartes
        //this.comodines = comodines;         //y para darle los comodines
    }


    public boolean esManoCompleta() {
        return cartas.size() == 8;
    }


    private void ordenarMano(){
        OrdenadorDeCartas.ordenarCartas(this.cartas);
    }


    public List<Carta> verCartasEnMano(){
        return cartas;
    }

    public void seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        jugada.seleccionar(carta);
        this.cartas.remove(carta);
    }

    public void desSeleccionarCarta(Carta carta){
        this.cartas.add(jugada.deseleccionar(carta));
        this.ordenarMano();
    }


    public int jugarCartas(){
        ManoDePoker manoDePoker = jugada.jugar();  //se juegan las cartas seleccionadas y devuelve los puntos obtenidos
        //comodines.aplicar(manoDePoker);
        return manoDePoker.calcularPuntaje();
    }


    public void descartarCartas(){
        //verificar que hayan descartes
        this.descartes--;
        jugada.descartar();
        //comodines.actualizarPorDescarte();
    }
}