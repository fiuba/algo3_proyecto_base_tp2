package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.entrega.Duplicador;
import edu.fiuba.algo3.entrega.Puntaje;

import java.util.Arrays;

public class Exclusividad {
    public void aplicar(Puntaje... puntos) {
        long contador = Arrays.stream(puntos)
                .filter(punto -> punto.obtenerPuntos() != 0)
                .count();

        if (contador == 1) {
            Arrays.stream(puntos)
                    .forEach(punto -> punto.agregarModificador(new Duplicador()));
        }
    }
}
