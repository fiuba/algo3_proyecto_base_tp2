package edu.fiuba.algo3.entrega;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Respuesta {
    private String opcion;
    private List<String> orden;
    private Grupo unGrupo;
    private Grupo otroGrupo;

    public Respuesta(String opcion) {
        this.opcion = opcion;
    }

    public Respuesta(String ... orden) {
        this.orden = new ArrayList<String>();
        Collections.addAll(this.orden, orden);
    }

    public Respuesta(Grupo unGrupo, Grupo otroGrupo) {
        this.unGrupo = unGrupo;
        this.otroGrupo = otroGrupo;
    }

    public boolean equals(String otroString) {
        return opcion.equals(otroString);
    }

    public boolean equals(List<String> orden) {
        return this.orden.equals(orden);
    }

    public boolean contiene(Grupo grupoParametro) {
        return this.unGrupo.equals(grupoParametro) || this.otroGrupo.equals(grupoParametro);
    }
}