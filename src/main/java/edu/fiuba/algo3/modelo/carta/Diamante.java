package edu.fiuba.algo3.modelo.carta;

public class Diamante implements Palo {
    public boolean esDeEstePalo(Palo palo){
        return (palo instanceof Diamante);
    }
}
