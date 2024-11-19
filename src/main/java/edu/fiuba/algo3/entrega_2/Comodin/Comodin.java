package edu.fiuba.algo3.entrega_2.Comodin;
import edu.fiuba.algo3.entrega_1.Modificable.Modificable;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;

public class Comodin {
    private Puntaje puntaje;
    private String descripcion;
    private String nombre;
    private Activacion activacion;

    public Comodin(String nombre, String descripcion, int valor, int multiplicador, Activacion activacion) {
        this.puntaje = new Puntaje(valor, multiplicador);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.activacion = activacion;
    }
    public void aplicarA(ManoDePoker mano) {
        if (esActivable( mano)) {
            //mano.aplicarModificacion(this.puntaje);
        }
    }

    public boolean esActivable(ManoDePoker mano) {
        return activacion.esActivable(mano);
    }

}

