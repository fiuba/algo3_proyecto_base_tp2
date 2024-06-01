package edu.fiuba.algo3.entrega_1;

import java.util.List;

public abstract class TipoMC {
    protected List<Number> opcionesCorrectas;

    public TipoMC(List<Number> opcionesCorrectas) {
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public abstract int validarSeleccion(List<Number> seleccion);
}
