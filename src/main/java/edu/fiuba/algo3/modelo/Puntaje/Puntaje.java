package edu.fiuba.algo3.modelo.Puntaje;

import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Modificable.Modificador;

public class Puntaje implements Modificable {
    private int valor;
    private double multiplicador;

    public Puntaje(int valor, double multiplicador){
        this.valor = valor;
        this.multiplicador = multiplicador;
    }

    public int calcularPuntaje(){
        double valorDecimal = (double) valor;
        return  (int)(valorDecimal * multiplicador);
    }

    public void modificarMultiplicador(int valorASumar){
        this.multiplicador += valorASumar;
    }

    public void modificarValor(int valorASumar){
        this.valor += valorASumar;
    }

    public boolean compararPuntaje(Puntaje puntaje){return puntaje.valor == this.valor && puntaje.multiplicador == this.multiplicador;}


    @Override
    public void aplicarModificacion(Puntaje puntaje) {
        this.valor = puntaje.valor;
        this.multiplicador = puntaje.multiplicador;
    }

    @Override
    public Boolean validarModificable(Modificador modificador) {
        return modificador.validarTipo("puntaje");
    }

    public double getMultiplicador(){
        return this.multiplicador;
    }



    public int obtenerValor(){
        return this.valor;
    }

    public void sumarValorDeUnPuntaje(Puntaje otroPuntaje){
        this.valor += otroPuntaje.obtenerValor();
    }

    public Puntaje sumarConPuntaje(Puntaje otroPuntaje) {
        return new Puntaje(valor + otroPuntaje.valor, multiplicador + otroPuntaje.multiplicador);
    }

    public boolean esMayor(Puntaje valor) {
        return valor.valor > this.valor;
    }
}
