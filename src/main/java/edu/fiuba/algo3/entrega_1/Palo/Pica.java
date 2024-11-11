package edu.fiuba.algo3.entrega_1.Palo;

public class Pica implements Palo {
    public Pica(){};
    @Override
    public boolean compararPalo(Palo otroPalo) {
        return otroPalo instanceof Pica;
    }
}
