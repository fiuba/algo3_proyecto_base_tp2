package edu.fiuba.algo3.modelo;

import java.util;

//Decorator pattern para equipamiento ?¿
public class Jugador {
    private int energia;
    private Gladiador gladiador;

    //private Casilla casilla;

    public Jugador(Gladiador gladiador) {
        this.gladiador = gladiador;
    }


}