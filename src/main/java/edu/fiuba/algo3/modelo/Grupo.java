package edu.fiuba.algo3.modelo;

import java.util.*;

public class Grupo {
    private List<Opcion> grupo;

    public Grupo(Opcion... opciones) {
        this.grupo = new ArrayList<Opcion>();
        Collections.addAll(this.grupo, opciones);
    }

    public PuntajeParcial puntuar(Respuesta... respuesta) {
        if (respuesta.length != grupo.size()) return new PuntajeParcial(0);

        boolean todasEncontradas = grupo.stream()
                .allMatch(op -> Arrays.stream(respuesta).anyMatch(op::equals));

        return todasEncontradas ? new PuntajeParcial(1) : new PuntajeParcial(0);
    }


    public List<Opcion> getOpciones(){
        return grupo;
    }

}
