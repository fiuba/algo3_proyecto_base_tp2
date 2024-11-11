package edu.fiuba.algo3.entrega_1.Valor;

public class Ka extends Valor {
    public Ka(){
        this.valor = 14;
    };
    @Override
    public boolean compararValor(Valor valor) {
        return this.valor < valor.valor;
    }
}
