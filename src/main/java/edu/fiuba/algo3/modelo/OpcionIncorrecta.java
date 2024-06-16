package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String opcion) {
        super(opcion);
    }

    public Puntaje puntuar(Respuesta respuesta) {
        if ( equals( respuesta ) ) {
            return new Puntaje(-1);
        }
        return new Puntaje(0);
    }

}
