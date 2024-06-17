package edu.fiuba.algo3.modelo;

public class Opcion {
    protected String opcion;

    public Opcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public boolean equals(Respuesta respuesta) {
        return respuesta.equals( opcion );
    }

    public Puntaje puntuar(Respuesta respuesta) {
        if ( equals(respuesta) ) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
}

