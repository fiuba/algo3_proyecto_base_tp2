package edu.fiuba.algo3.modelo;

import java.util.List;

public class Exclusividad implements ModificadorGlobal{
    public void aplicar(List<PuntajeParcial> puntajes) {

        long contador = puntajes.stream()
                .filter(punto -> punto.obtenerPuntos() != 0)
                .count();

        if (contador == 1) {
            puntajes.forEach(punto -> punto.agregarModificador(new Duplicador()));
        }
    }
}
