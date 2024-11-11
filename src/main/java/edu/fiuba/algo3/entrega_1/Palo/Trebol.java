package edu.fiuba.algo3.entrega_1.Palo;

public class Trebol implements Palo {

    public Trebol(){}

    @Override
    public boolean compararPalo(Palo otroPalo) {
        return otroPalo instanceof Trebol;
    }
}
