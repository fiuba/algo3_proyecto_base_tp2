package edu.fiuba.algo3.modelo.Mano;

import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ManoDeComodines.ManoDeComodines;
import edu.fiuba.algo3.modelo.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {

    private Mazo mazo;
    private List<Carta> cartas;
    private Jugada jugada = new Jugada();
    private int descartes;
    private ManoDeComodines comodines;


    public Mano(Mazo mazo,int descartes, ManoDeComodines comodines) {
        this.comodines = comodines;
        this.mazo = mazo;
        this.cartas = mazo.generarCartas();
        this.ordenarMano();
        this.descartes = descartes;
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
        comodines.aplicarA(manoDePoker);
        return manoDePoker.calcularPuntaje();
    }


    public void descartarCartas(){

        this.descartes--;
        jugada.descartar();
        //comodines.actualizarPorDescarte();
    }
    //este le aplica a la mano que le corresponde
    public void aplicarTarot(Tarot tarot){
        this.jugada.aplicarTarotAMano(tarot);
    }
}