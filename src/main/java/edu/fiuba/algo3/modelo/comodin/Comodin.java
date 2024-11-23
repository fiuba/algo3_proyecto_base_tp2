package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import java.util.List;

public class Comodin {
    private Puntaje puntaje;
    private String descripcion;
    private String nombre;
    private List<Activacion> activaciones;

    // Cambiar de activacion a lista de activaciones
    public Comodin(String nombre, String descripcion, int valor, int multiplicador, List<Activacion> activaciones) {
        this.puntaje = new Puntaje(valor, multiplicador);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.activaciones = activaciones;
    }
    public Puntaje aplicarA(ManoDePoker mano) {
        Puntaje puntajeMano = mano.devolverPuntaje();
        for (Activacion activacion : activaciones) {
            if (!activacion.esActivable(mano)) {
                return puntajeMano;
            }
        }
        return puntajeMano.sumarConPuntaje(this.puntaje);
    }

}


