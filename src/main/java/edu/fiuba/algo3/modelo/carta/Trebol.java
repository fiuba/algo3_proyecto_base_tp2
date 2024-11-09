package edu.fiuba.algo3.modelo.carta;

public class Trebol implements Palo {
    public boolean esDeEstePalo(Palo palo){
        return (palo instanceof Trebol);
    }
}