package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Descartes;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerDescarte extends Joker{
    private Descartes descartes;

    public JokerDescarte (String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion, Descartes descartes){
        super(nombre, descripcion, modificador, modificacion);
        this.descartes = descartes;

    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker){
        for(int i = 0 ; i < descartes.descartesRealizados() ; i++){
            modificador.modificar(puntuacionTirada, modificacion);
        }
    }

}
