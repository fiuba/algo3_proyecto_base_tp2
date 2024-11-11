package edu.fiuba.algo3.modelo;



public class Poker implements Carta {
    private String caracter;
    private int multiplicador;
    private int valorNumerico;
    public Palo palo;

    public Poker(int multiplicador, String caracter, int valorNumerico, Palo palo) {
        this.multiplicador = multiplicador;
        this.caracter = caracter;
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

