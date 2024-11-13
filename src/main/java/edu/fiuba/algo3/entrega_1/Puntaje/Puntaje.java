package edu.fiuba.algo3.entrega_1.Puntaje;

import edu.fiuba.algo3.entrega_1.Modificable.Modificable;

public class Puntaje implements Modificable {
    private int valor;
    private int multiplicador;

    public Puntaje(int valor, int multiplicador){
        this.valor = valor;
        this.multiplicador = multiplicador;
    }

    public int calcularPuntaje(){
        return valor  * multiplicador;
    }

    public void modificarMultiplicador(int valorASumar){
        this.multiplicador += valorASumar;
    }

    public void modificarValor(int valorASumar){
        this.valor += valorASumar;
    }

    public boolean compararPuntaje(Puntaje puntaje){return puntaje.valor == this.valor && puntaje.multiplicador == this.multiplicador;}


    @Override
    public void aplicarModificacion(int valor) {
        this.valor = valor;
    }

    public Puntaje sumarConPuntaje(Puntaje otroPuntaje) {
        return new Puntaje(valor + otroPuntaje.valor, multiplicador + otroPuntaje.multiplicador);
    }
}
