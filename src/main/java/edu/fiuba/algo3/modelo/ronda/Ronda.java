package edu.fiuba.algo3.modelo.ronda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ManoDeComodines.ManoDeComodines;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class Ronda {
    private Jugador jugador;
    private Tienda tienda;
    private Mazo mazo;
    private Mano manoActual;
    private int nro;
    private int manos;
    private int descartes;
    private int puntajeASuperar;

    public Ronda(Tienda tienda, int nro, int manos, int descartes, int puntajeASuperar) {
        this.tienda = tienda;
        this.nro = nro;
        this.manos = manos;
        this.descartes = descartes;
        this.puntajeASuperar = puntajeASuperar;
    }

    public Tienda getTienda() {
        return tienda;
    }


    public List<Carta> mostrarCartasDeManos() {
        return this.jugador.verCartasEnMano();
    }

    public void empezarRonda(Jugador jugador, Mazo mazo) {
        this.manoActual = new Mano(mazo, this.descartes, new ManoDeComodines());
        this.jugador.asignarMano(manoActual);
    }

    public void seleccionar(Carta carta) {
        this.jugador.seleccionar(carta);
    }



}
