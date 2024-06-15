package edu.fiuba.algo3.entrega;

import java.util.Arrays;
import java.util.List;

public class Exclusividad implements ModificadorGlobal{
    public void aplicar(List<Puntaje> puntajes) {

        long contador = puntajes.stream()
                .filter(punto -> punto.obtenerPuntos() != 0)
                .count();

        if (contador == 1) {
            puntajes.forEach(punto -> punto.agregarModificador(new Duplicador()));
        }
    }
}
