package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class SumadorDeMultiplicador extends Efecto {
    public SumadorDeMultiplicador(EfectoParseado efecto) {
        super(efecto);
    }

    @Override
    public Puntaje aplicarEfecto(Puntaje puntaje) {
        puntaje.modificarMultiplicador(this.multiplicador);
        return null;
    }
}
