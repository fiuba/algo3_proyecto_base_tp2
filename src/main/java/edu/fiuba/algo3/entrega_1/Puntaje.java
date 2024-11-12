package edu.fiuba.algo3.entrega_1;

public class Puntaje implements Modificable {
    private int multiplicador;
    private int valor;

    public Puntaje(int multiplicador, int valor ) {
        this.multiplicador = multiplicador;
        this.valor = valor;
    }

    @Override
    public void aplicarModificacion(int multiplicador) {
        this.multiplicador =  multiplicador;
    }

    public int getPuntaje() {
        return multiplicador * valor ;
    }
}