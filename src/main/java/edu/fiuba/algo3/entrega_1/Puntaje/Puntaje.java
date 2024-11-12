package edu.fiuba.algo3.entrega_1.Puntaje;

public class Puntaje {
    private int valor;
    private int multiplicador;

    public Puntaje(int valor, int multiplicador){
        this.valor = valor;
        this.multiplicador = multiplicador;
    }

    public int calcularPuntajeFinal(){
        return valor * multiplicador;
    }

    public void modificarMultiplicador(int valorASumar){
        this.multiplicador += valorASumar;
    }

    public void modificarValor(int valorASumar){
        this.valor += valorASumar;
    }
}
