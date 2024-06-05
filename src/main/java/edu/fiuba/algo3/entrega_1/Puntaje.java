package edu.fiuba.algo3.entrega_1;

public class Puntaje {
    private int puntaje;

    public Puntaje() {
        this.puntaje = 0;
    }
    public Puntaje(int puntajeInicial) {
        this.puntaje = puntajeInicial;
    }

    public void sumar(Puntaje otroPuntaje) {
        this.puntaje += otroPuntaje.puntaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puntaje otroPuntaje = (Puntaje) o;

        return (puntaje == otroPuntaje.puntaje);
    }
}
