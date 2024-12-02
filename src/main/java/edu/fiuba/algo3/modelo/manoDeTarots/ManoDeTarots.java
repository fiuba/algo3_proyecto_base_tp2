package edu.fiuba.algo3.modelo.manoDeTarots;

import edu.fiuba.algo3.modelo.Seleccionable.Seleccionable;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.ArrayList;

public class ManoDeTarots {
    private ArrayList<Tarot> tarots;
    private int cantidadMaxima;

    public ManoDeTarots(){
        this.tarots = new ArrayList<Tarot>();
        this.cantidadMaxima = 2;

    }
    public void guardar(Seleccionable tarot){
        //primero tendría que verificar que es un tarot
        this.tarots.add(tarot);
    }
}
