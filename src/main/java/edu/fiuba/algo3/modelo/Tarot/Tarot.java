package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

import java.util.ArrayList;

public class Tarot {
    private Puntaje puntaje;
    private String descripcion;
    private String nombre;
    private Modificable modificable;
    public Tarot(String nombre, String descripcion, Puntaje puntaje, Modificador modificador) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.modificador = modificador;
    }

    //la carta tarot solo se le puede aplicar a la carta o mano indicada
    //hago otro constructor que tenga en cuenta el tipo de objeto que puede modificar

    public Tarot(int valor, int multiplicador, Modificable modificable){
        this.puntaje = new Puntaje(valor, multiplicador);
        this.modificable = modificable;
    }
    public void aplicarA(Modificable modificable) {
        if(modificador.modificar(modificable)) {
            modificable.aplicarModificacion(this.puntaje);
        }else{
             throw new ModificableEquivocadoException();
        }
    }

    public void aplicarModificacion(Modificable modificable){
        if(this.modificable.esIgual(modificable)){
            modificable.aplicarModificacion(this.puntaje);
        }
    }

    public void aplicarModificacion(ArrayList<ManoDePoker> manosDePoker){
        for(ManoDePoker manoDePoker : manosDePoker){
            if(this.modificable.equals(manoDePoker)){
                manoDePoker.aplicarModificacion(this.puntaje);
            }
        }
    }
}

