package edu.fiuba.algo3.entrega_1.Valor;

public class Cuatro extends Valor {

    public Cuatro() {
        this.valor = 4;
    }

    @Override
    public boolean compararValor(Valor valor) {
        return  this.valor < valor.valor;
    }
}
