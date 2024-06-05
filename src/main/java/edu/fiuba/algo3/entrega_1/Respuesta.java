package edu.fiuba.algo3.entrega_1;

public class Respuesta {
    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean equals(String otroString) {
        return respuesta.equals(otroString);
    }
}
