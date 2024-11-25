package edu.fiuba.algo3.modelo.Mano;

import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {

    private Mazo mazo;
    private List<Carta> cartas = new ArrayList<>();
    private Jugada jugada = new Jugada();
    private int descartes;
    //private MazoDeComodines comodines;

    public Mano(Mazo mazo) {
        this.cartas = mazo.repartirCartas();
        this.ordenarMano();
        this.descartes = 3;
        //this.comodines = new MazoDeComodines();

    }

    public Mano(Mazo mazo,int descartes, MazoDeComodines comodines) {
        //this.proveedor = proveedor;
        this.mazo = mazo;
        this.cartas = mazo.repartirCartas();
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