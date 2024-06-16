package edu.fiuba.algo3.modelo;

import java.util.*;

public class Grupo {
    private List<Opcion> grupo;

    public Grupo(Opcion... opciones) {
        this.grupo = new ArrayList<Opcion>();
        Collections.addAll(this.grupo, opciones);
    }

    public Puntaje puntuar(Respuesta... respuesta) {
        if (respuesta.length != grupo.size()) return new Puntaje(0);

        boolean todasEncontradas = grupo.stream()
                .allMatch(op -> Arrays.stream(respuesta).anyMatch(op::equals));

        return todasEncontradas ? new Puntaje(1) : new Puntaje(0);
    }

}
