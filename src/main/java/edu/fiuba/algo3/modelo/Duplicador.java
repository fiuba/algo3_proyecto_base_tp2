package edu.fiuba.algo3.modelo;

public class Duplicador implements ModificadorIndividual {
    private static final int CONSTANTE_DUPLICADORA = 2;
    @Override
    public int modificar(int a) {
        return CONSTANTE_DUPLICADORA*a;
    }
}
