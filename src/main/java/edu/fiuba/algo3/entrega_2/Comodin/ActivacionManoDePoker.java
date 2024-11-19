package edu.fiuba.algo3.entrega_2.Comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;

public class ActivacionManoDePoker implements Activacion{
    private String tipoManoEsperada;

    public ActivacionManoDePoker(String tipoManoEsperada) {
        this.tipoManoEsperada = tipoManoEsperada;
    }

    @Override
    public boolean esActivable(ManoDePoker mano) {
        return mano.equals(tipoManoEsperada);
    }
}