package edu.fiuba.algo3.entrega_2.Comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;

public class ActivacionProbabilidad implements Activacion {
    private int probabilidad;

    public ActivacionProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public boolean esActivable(ManoDePoker mano) {
        return /* mano.obtenerProbailidad()*/ 0 < probabilidad;
    }
}