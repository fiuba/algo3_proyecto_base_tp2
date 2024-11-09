package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class Carta {
    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        if (numero > 13 || numero <= 0) {
            throw new NumeroInvalidoException() ;
        }
        this.numero = numero;
        this.palo = palo;
    }

    public Puntaje obtenerPuntaje() {
        return new Puntaje(this.numero, 1);
    }

    private Palo obtenerPalo() {
        return this.palo;
    }

    public boolean esDelMismoPalo(Carta carta) {
        return this.palo.esDeEstePalo(carta.obtenerPalo());
    }
}