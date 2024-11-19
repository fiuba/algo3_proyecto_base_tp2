package edu.fiuba.algo3.entrega_1.Palo;

public class Pica implements Palo {
    public Pica(){};
    @Override
    public boolean sonMismoPalo(Palo otroPalo) {
        return otroPalo.esPica();
    }

    @Override
    public boolean esDiamante() {
        return false;
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
        return true;
    }
}
