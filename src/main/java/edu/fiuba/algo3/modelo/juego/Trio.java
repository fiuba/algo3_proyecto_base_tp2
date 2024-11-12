package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.naipes.carta.Carta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trio extends Juego {
    public Puntaje puntuarMano(ArrayList<Carta> cartas) {
        Puntaje puntaje = this.modificador.obtenerPuntaje(new Puntaje(30, 3));
        for (Carta carta : cartas) {
            puntaje.sumar(carta.obtenerPuntaje());
        }
        return puntaje;
    }

    public boolean sosJuego(ArrayList<Carta> cartas) {
        if (cartas.size() < 3) {
            return false;
        }
        Map<Integer, Integer> frecuenciaValores = new HashMap<>();
        for (Carta carta : cartas) {
            int valor = carta.obtenerValor();
            frecuenciaValores.put(valor, frecuenciaValores.getOrDefault(valor, 0) + 1);
        }
        for (int frecuencia : frecuenciaValores.values()) {
            if (frecuencia >= 3) {
                return  true;
            }
        }
        return false;
    }
}
