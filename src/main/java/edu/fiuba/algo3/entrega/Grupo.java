package edu.fiuba.algo3.entrega;

import java.util.*;

public class Grupo {
    private List<String> grupo;

    public Grupo(String... grupo) {
        this.grupo = new ArrayList<String>();
        Collections.addAll(this.grupo, grupo);
    }

    public Puntaje puntuar(Respuesta respuesta) {
        if (equals( respuesta )) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }

    public boolean equals(Respuesta respuesta) {
        return respuesta.contiene(this);
    }

    public boolean equals(Grupo otroGrupo) {
        return this.grupo.equals(otroGrupo.grupo);
    }
}
