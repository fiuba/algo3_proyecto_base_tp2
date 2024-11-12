package edu.fiuba.algo3.entrega_1.Palo;

public class Corazones implements Palo{

    public Corazones(){
    }


    @Override
    public boolean compararPalo(Palo otroPalo) {
        return otroPalo instanceof Corazones;
    }
}
