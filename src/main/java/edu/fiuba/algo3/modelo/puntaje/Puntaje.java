package edu.fiuba.algo3.modelo.puntaje;

public class Puntaje {
    private int puntos;
    private int multiplicador;

    public Puntaje(int puntos, int multiplicador) {
        if (puntos < 0) {
            throw new PuntosInvalidosException();
        }
        if (multiplicador <= 0) {
            throw new MultiplicadorInvalidosException();
        }
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    private int obtenerPuntos() {
        return puntos;
    }

    private int obtenerMultiplicador() {
        return multiplicador;
    }

    public int calcularValor() {
        return puntos * multiplicador;
    }

    public void sumarPuntos(Puntaje puntaje) {
        this.puntos += puntaje.obtenerPuntos();
    }

    public void sumarMultiplicador(Puntaje puntaje) {
        this.multiplicador += puntaje.obtenerMultiplicador();
    }

    public boolean esMayor(Puntaje puntaje) {
        return this.calcularValor() > puntaje.calcularValor();
    }
}
