package edu.fiuba.algo3.modelo.carta;

public class Pica implements Palo {
    public boolean esDeEstePalo(Palo palo){
        return (palo instanceof Pica);
    }
}