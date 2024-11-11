package edu.fiuba.algo3.entrega_1.Valor;

public class Dos extends Valor {

    public Dos() {
        this.valor = 2;
    }

    @Override
    public boolean compararValor(Valor valor) {
        return this.valor < valor.valor;
    }
}
