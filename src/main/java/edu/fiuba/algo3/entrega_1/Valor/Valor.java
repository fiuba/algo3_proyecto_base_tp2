package edu.fiuba.algo3.entrega_1.Valor;

public abstract class Valor{
    protected int valor;

    public abstract boolean compararValor(Valor valor);
    public int getValor(){
        return this.valor;
    }

    @Override
    public boolean equals(Object obj){
        int valor = (int) obj;
        return this.valor == valor;
    }
}
