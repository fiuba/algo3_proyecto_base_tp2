package edu.fiuba.algo3.modelo;

public class Puntaje {
    int multiplicador;
    int valorBase;

    public Puntaje (int multiplicador, int valorBase) {
        this.multiplicador = multiplicador;
        this.valorBase = valorBase;
    }

    public void sumarMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }

    public void sumarValorBase(int valorBase) {
        this.valorBase += valorBase;
    }

    public int calcularTotal() {
        return valorBase * multiplicador;
    }
}
