package edu.fiuba.algo3.entrega_1.Palo;

public class Diamante implements Palo {
    public Diamante() {}
    @Override
    public boolean sonMismoPalo(Palo otroPalo) {
        return otroPalo.esDiamante();
    }

    @Override
    public boolean esDiamante() {
        return true;
    }

    @Override
    public boolean esTrebol() {
        return false;
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
