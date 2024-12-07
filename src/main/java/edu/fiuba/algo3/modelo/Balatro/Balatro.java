package edu.fiuba.algo3.modelo.Balatro;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMazo;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.ronda.Tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Balatro {

    private FactoryRondas factoryRondas;
    private FactoryDeMazo factoryDeMazo;
    private FactoryDeTarot factoryDeTarot;
    private FactoryComodines factoryComodines;
    private Jugador jugador;
    private List<Ronda> rondas;
    private Mazo mazo;
    private Ronda rondaActual;

    public Balatro(String rutaDeBalatro, String rutaDeMazo, String rutaDeTarots, String rutaDeComodines, String nombreDeJugador) throws IOException {
        this.factoryDeMazo = new FactoryDeMazo(rutaDeMazo);
        this.factoryDeTarot = new FactoryDeTarot(rutaDeTarots);
        this.factoryComodines = new FactoryComodines(rutaDeComodines);
        this.factoryRondas = new FactoryRondas(rutaDeBalatro, this.factoryDeTarot, this.factoryDeMazo, this.factoryComodines);
        this.jugador = Jugador.CrearJugador(nombreDeJugador);
        this.mazo = new Mazo(this.factoryDeMazo);
        this.rondas = new ArrayList<>();
        this.rondas = factoryRondas.generarRondas();
        this.rondaActual = this.rondas.get(0);
        this.rondaActual.empezarRonda(this.jugador, this.mazo);
    }


    public List<Carta> mostrarCartasDeLaMano() {
        return jugador.verCartasEnMano();
    }

    public Tienda mostrarTienda() {
        return rondaActual.verTienda();
    }

    public Puntaje seleccionar(Carta carta) {
       return rondaActual.seleccionar(carta);
    }

    public Puntaje deseleccionarCarta(Carta carta) {
        return rondaActual.deSeleccionarUnaCarta(carta);
    }

    public void descartar() {
        rondaActual.descartar();
    }

    public int jugar() {
        Puntaje puntaje = rondaActual.jugar();
        if(rondaActual.seGanoLaRonda()){
            rondaActual = rondas.iterator().next();
        }else if(rondaActual.sePerdioLaRonda()){
            throw new Derrota();
        }
        return puntaje.calcularPuntaje();
    }
}
