package edu.fiuba.algo3.entrega_1.Palo;

public class Diamante implements Palo {
    public Diamante() {}
    @Override
    public boolean compararPalo(Palo otroPalo) {
        return otroPalo instanceof Diamante;
    }
}
