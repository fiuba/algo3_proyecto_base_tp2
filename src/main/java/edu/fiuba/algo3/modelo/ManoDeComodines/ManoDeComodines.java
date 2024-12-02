package edu.fiuba.algo3.modelo.ManoDeComodines;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Seleccionable.Seleccionable;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.ArrayList;

public class ManoDeComodines {
    private ArrayList<Comodin> comodines;
    private int capacidadMaxima = 5; //no pueden haber mas de 5 comodines


    public ManoDeComodines(){
        this.comodines = new ArrayList<Comodin>();
    }

    public void seleccionar(Comodin comodin){
        this.comodines.add(comodin);
    }

    public void aplicarA(ManoDePoker mano){
        for(Comodin comodin : this.comodines){
            comodin.aplicarA(mano);
        }
    }

    public void guardar(Seleccionable comodin){
        //primero tendría que verificar que es un comodin
        this.comodines.add(comodin);
    }
    /*


    a este mazo lo va a tener el jugador, se instancia cuando se instancia el jugador, solo va a haber uno de comodines/
     */
}
