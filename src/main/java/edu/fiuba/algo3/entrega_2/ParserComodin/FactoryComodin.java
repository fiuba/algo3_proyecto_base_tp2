package edu.fiuba.algo3.entrega_2.ParserComodin;

import edu.fiuba.algo3.entrega_2.comodin.Comodin;

import java.util.List;

public class FactoryComodin {
    String ruta;

    public FactoryComodin(String ruta) {
        this.ruta = ruta;
    }

    public List<Comodin> generarComodin() {
        List<ComodinParseado> comodinesFake = ParserComodin.convertirDeJsonAFakeComodin(this.ruta);
        List<Comodin> comodines = ParserComodin.parsearDeFakeComodinAComodin(comodinesFake);
        return comodines;
    }
}

