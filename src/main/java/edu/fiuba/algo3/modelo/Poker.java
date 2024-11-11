package edu.fiuba.algo3.modelo;



public class Poker implements Carta {
    private int multiplicador;
    private String caracter;
    private int valorNumerico;
    public Palo palo;
    public Poker(int multiplicador,String caracter,int valorNumerico, Palo palo){
        this.multiplicador = multiplicador;
        this.caracter = caracter;
        this.valorNumerico = valorNumerico;
        this.palo = palo
    }
    public int usar(){
        return multiplicador;
    }
    public Palo getPalo(){
        return this.palo;
    }
}

