package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public abstract class Juego {
    public static Juego chequearJuego(ArrayList<Carta> cartas) {
        ArrayList<Juego> juegos = new ArrayList<>(List.of(new CartaAlta(),
                new Par(), new DoblePar(), new Trio(), new Escalera(), new Color(),
                new FullHouse(), new Poker(), new EscaleraDeColor(), new EscaleraReal()));
        Puntaje puntajeMaximo = new Puntaje(0, 1);
        Juego juegoSeleccionado = new CartaAlta();
        for (Juego juego : juegos) {
            if (juego.sosJuego(cartas)) {
                if (juego.puntuarMano(cartas).calcularValor() > puntajeMaximo.calcularValor()) {
                    juegoSeleccionado = juego;
                }
            }
        }
        return juegoSeleccionado;
    }

    abstract public boolean sosJuego(ArrayList<Carta> cartas);

    abstract public Puntaje puntuarMano(ArrayList<Carta> cartas);
}
