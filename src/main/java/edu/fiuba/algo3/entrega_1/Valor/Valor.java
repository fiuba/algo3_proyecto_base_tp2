package edu.fiuba.algo3.entrega_1.Valor;

public abstract class Valor{
    protected int valor;

    public boolean esMayor(Valor valor){
      return  this.valor < valor.valor;
    };

    public boolean esIgualA(Valor valor){
        return this.valor == valor.valor;
    }
}
