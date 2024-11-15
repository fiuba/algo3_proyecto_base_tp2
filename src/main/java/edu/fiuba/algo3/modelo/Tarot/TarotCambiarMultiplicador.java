package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class TarotCambiarMultiplicador extends Tarot {
    private int multiplicador;

    public TarotCambiarMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public ManoDePoker aplicarEfecto(ManoDePoker manoDePoker){
        return manoDePoker.aplicarMultiplicador(multiplicador);
    }
}
