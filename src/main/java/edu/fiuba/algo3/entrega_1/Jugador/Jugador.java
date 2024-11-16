package edu.fiuba.algo3.entrega_1.Jugador;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Mano.Mano;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.List;

public class Jugador {
    private String nombre;
    private Mano mano;
    private Jugada jugada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.jugada = new Jugada();
    }


    public void asignarMano(Mano mano) {
        this.mano = mano;
    }

    public Jugada armarJugada(List<Carta> cartas) {
        List<Carta> cartasJugadas = this.mano.jugarCartas(cartas);
        for (Carta carta : cartasJugadas) {
            jugada.seleccionar(carta);
        }
        return jugada;
    }

    public List<Carta> verCartasEnMano(){
        return mano.verCartasEnMano();
    }

    public boolean puedeJugar() {
        return this.mano.esManoCompleta();
    }
}
