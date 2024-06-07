package edu.fiuba.algo3.entrega;

public class OpcionIncorrecta implements Opcion {
    private String opcion;
    public OpcionIncorrecta(String opcion) {
        this.opcion = opcion;
    }

    @Override
    public Puntaje puntuar(Respuesta respuesta) {
        if ( respuesta.equals( opcion ) ) {
            return new Puntaje(-1);
        }
        return new Puntaje(0);
    }

    public boolean equals(Respuesta respuesta) {
        return respuesta.equals( opcion );
    }

}
