package edu.fiuba.algo3.modelo;



public class Poker implements Carta {
    String simbolo;
    int multiplicador;
    int valorNumerico;
    Palo palo;

    public Poker(int multiplicador, String simbolo, int valorNumerico, Palo palo) {
        this.multiplicador = multiplicador;
        this.simbolo = simbolo;
        this.valorNumerico = valorNumerico;
        this.palo = palo;
    }
    public int usar() {
        return valorNumerico;
    }

    public Palo getPalo() {
        return this.palo;
    }

    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public int calcularValor() {
        return this.valorNumerico * this.multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }
}

