package edu.fiuba.algo3.entrega;

public class OpcionCorrecta implements Opcion {
    private String opcion;

    public OpcionCorrecta(String opcion) {
        this.opcion = opcion;
    }

    @Override
    public Puntaje puntuar(Respuesta respuesta) {
        if ( equals(respuesta) ) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }

    public boolean equals(Respuesta respuesta) {
        return respuesta.equals( opcion );
    }
}