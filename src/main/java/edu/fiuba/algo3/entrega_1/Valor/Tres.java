package edu.fiuba.algo3.entrega_1.Valor;

public class Tres extends Valor {

    public Tres(){
        this.valor = 3;
    }
    @Override
    public boolean compararValor(Valor valor) {
        return this.valor < valor.valor;
    }
}
