package edu.fiuba.algo3.entrega_1.Palo;

public class Corazon implements Palo{

    public Corazon(){
    }


    @Override
    public boolean sonMismoPalo(Palo otroPalo) {
        return otroPalo.esCorazon();
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
        return true;
    }

    @Override
    public boolean esPica() {
        return false;
    }
}
