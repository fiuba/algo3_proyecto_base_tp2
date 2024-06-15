package edu.fiuba.algo3.entrega;

public class Triplicador implements ModificadorIndividual {
    private static final int CONSTANTE_TRIPLICADORA = 3;
    @Override
    public int modificar(int a) {
        return CONSTANTE_TRIPLICADORA*a;
    }
}
