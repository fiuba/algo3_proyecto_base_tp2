package edu.fiuba.algo3.entrega_1;

import java.util.List;

public class MCPenalidad extends TipoMC {

    public MCPenalidad(List<Number> opcionesCorrectas) {
        super(opcionesCorrectas);
    }

    public int validarSeleccion(List<Number> seleccion) {
        int puntaje = 0;
        for (Number opcion : seleccion) {
            if (opcionesCorrectas.contains(opcion)) {
                puntaje++;
            }
            else {
                puntaje--;
            }
        }
        return puntaje;
    }
}
