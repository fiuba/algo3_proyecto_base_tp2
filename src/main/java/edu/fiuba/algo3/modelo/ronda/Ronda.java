package edu.fiuba.algo3.modelo.ronda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ManoDeComodines.ManoDeComodines;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.List;

public class Ronda {
    private Jugador jugador;
    private Tienda tienda;
    private Mano manoActual;
    private Mazo mazo;
    private int nro;
    private int manos;
    private int descartes;
    private int puntajeASuperar;
    private int puntajeDeRonda;
    private ManoDeComodines manoDeComodines;

    public Ronda(Tienda tienda, int nro, int manos, int descartes, int puntajeASuperar) {
        this.tienda = tienda;
        this.nro = nro;
        this.manos = manos;
        this.descartes = descartes;
        this.puntajeASuperar = puntajeASuperar;
        this.puntajeDeRonda = 0;
        this.manoDeComodines = new ManoDeComodines();
    }

    public Tienda verTienda() {
        return tienda;
    }


    public List<Carta> mostrarCartasDeManos() {
        return this.jugador.verCartasEnMano();
    }

    public void empezarRonda(Jugador jugador, Mazo mazo) {
        this.mazo = mazo;
        this.manoActual = new Mano(this.mazo, this.descartes, manoDeComodines);
        this.jugador = jugador;
        this.jugador.asignarMano(manoActual);
    }
    private void arrancarNuevaMano() {
        this.manoActual = new Mano(this.mazo, descartes, manoDeComodines);

    }

    public void seleccionar(Carta carta) {
        this.jugador.seleccionar(carta);
    }


    public Puntaje jugar() {
        int manosJugadas = 0;
        Puntaje puntajeActual = new Puntaje(0, 1);
        if(manosJugadas <= this.manos) {
            puntajeActual = this.jugador.jugarMano();
            this.arrancarNuevaMano();
            puntajeDeRonda += puntajeActual.calcularPuntaje();
            manosJugadas++;
            if(manosJugadas >= this.manos){
                throw new ManosExedidas();
            }
        }
        return puntajeActual;
    }

    public boolean seGanoLaRonda() {
        return this.puntajeDeRonda >= this.puntajeASuperar;
    }

    public void comprarComodin(Comodin comodin) {
        manoDeComodines.guardar(comodin);
    }
}
