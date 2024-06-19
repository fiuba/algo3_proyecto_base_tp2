package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String opcion) {
        super(opcion);
    }

    public PuntajeParcial puntuar(Respuesta respuesta) {
        if ( equals( respuesta ) ) {
            return new PuntajeParcial(-1);
        }
        return new PuntajeParcial(0);
    }

}
