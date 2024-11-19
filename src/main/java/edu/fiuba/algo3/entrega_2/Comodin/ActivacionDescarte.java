package edu.fiuba.algo3.entrega_2.Comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;


public class ActivacionDescarte implements Activacion {
    @Override
    public boolean esActivable(ManoDePoker mano) {
        return /*mano.huboDescartes()*/ true ;
    }
}