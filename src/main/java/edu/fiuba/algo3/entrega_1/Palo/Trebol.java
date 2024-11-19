package edu.fiuba.algo3.entrega_1.Palo;

public class Trebol implements Palo {

    public Trebol(){}

    @Override
    public boolean sonMismoPalo(Palo otroPalo) {
        return otroPalo.esTrebol();
    }

    @Override
    public boolean esDiamante() {
        return false;
    }

    @Override
    public boolean esTrebol() {
        return true;
    }

    @Override
    public boolean esCorazon() {
        return false;
    }

    @Override
    public boolean esPica() {
        return false;
    }
}
