package edu.fiuba.algo3.entrega_1;

import java.util.List;

public class MCClasico extends TipoMC {

    public MCClasico(List<Number> opcionesCorrectas) {
        super(opcionesCorrectas);
    }

    public int validarSeleccion(List<Number> seleccion) {
        if ( opcionesCorrectas.equals(seleccion) ) {
            return 1;
        }
        return 0;
    }

}