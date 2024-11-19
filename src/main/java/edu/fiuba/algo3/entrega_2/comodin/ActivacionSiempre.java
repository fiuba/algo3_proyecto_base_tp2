package edu.fiuba.algo3.entrega_2.comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;

public class ActivacionSiempre implements Activacion {
    @Override
    public boolean esActivable(ManoDePoker mano) {
        return true;
    }
}