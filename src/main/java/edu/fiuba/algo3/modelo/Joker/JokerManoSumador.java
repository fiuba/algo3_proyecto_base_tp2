package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class JokerManoSumador implements Joker{

    private String modificacion;
    private int factorModificacion;
    private ManoDePoker tipo;

    public JokerManoSumador(String modificacion, int factorModificacion, ManoDePoker tipo) {
        this.modificacion = modificacion;
        this.factorModificacion = factorModificacion;
        this.tipo = tipo;
    }
    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker tipo) {
        if(this.tipo.getClass().equals(tipo.getClass())){
            puntuacion.agregar(modificacion, factorModificacion);
        }
    }
}
