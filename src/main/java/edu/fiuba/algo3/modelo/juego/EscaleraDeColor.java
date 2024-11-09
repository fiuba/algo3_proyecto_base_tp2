package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EscaleraDeColor extends Juego{
    public Puntaje puntuarMano(ArrayList<Carta> cartas) {
        Puntaje puntaje = new Puntaje(100, 8);
        for (Carta carta : cartas) {
            puntaje.sumarPuntos(carta.obtenerPuntaje());
        }
        return puntaje;
    }

    public boolean sosJuego(ArrayList<Carta> cartas) {
        if (cartas.size() != 5) {
            return false;
        }
        Carta cartaPalo = cartas.get(0);
        for (Carta carta : cartas.subList(1, cartas.size())) {
            if (!carta.esDelMismoPalo(cartaPalo)) {
                return false;
            }
        }
        Collections.sort(cartas, Comparator.comparingInt(Carta::obtenerValor));
        for (int i = 1; i < cartas.size(); i++) {
            int valorActual = cartas.get(i).obtenerValor();
            int valorAnterior = cartas.get(i - 1).obtenerValor();
            if (valorActual != valorAnterior + 1) {
                return false;
            }
        }
        return true;
    }
}
