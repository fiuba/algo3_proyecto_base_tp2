package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class PuntajeTotal {
    private List<PuntajeParcial> puntosParciales;

    public PuntajeTotal() {
        this.puntosParciales = new ArrayList<PuntajeParcial>();
    }
    public void agregar(PuntajeParcial puntos) {
        puntosParciales.add(puntos);
    }

    public int obtenerPuntaje() {
        return puntosParciales.stream()
                .reduce(new PuntajeParcial(0), (acum, punto) -> {
                    acum.sumar(punto);
                    return acum;
                })
                .obtenerPuntos();
    }

}
