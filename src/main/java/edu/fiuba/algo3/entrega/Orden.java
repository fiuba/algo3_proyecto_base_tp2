package edu.fiuba.algo3.entrega;

import java.util.*;

public class Orden {
    private List<String> orden;

    public Orden(String... orden) {
        this.orden = new ArrayList<String>();
        Collections.addAll(this.orden, orden);
    }

    public Puntaje puntuar(Respuesta respuesta) {
        if (equals( respuesta )) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }

    public boolean equals(Respuesta respuesta) {
        return respuesta.equals(this.orden);
    }
}
