package edu.fiuba.algo3.entrega_1.Palo;

public class Corazon implements Palo{

    public Corazon(){
    }


    @Override
    public boolean compararPalo(Palo otroPalo) {
        return otroPalo instanceof Corazon;
    }
}
