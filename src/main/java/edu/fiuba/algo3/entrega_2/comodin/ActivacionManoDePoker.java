package edu.fiuba.algo3.entrega_2.comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;

public class ActivacionManoDePoker implements Activacion{
    private ManoDePoker mano;

    public ActivacionManoDePoker(ManoDePoker tipoManoEsperada) {
        this.mano = tipoManoEsperada;
    }

    @Override
    public boolean esActivable(ManoDePoker mano) {
        return mano.equals(this.mano);
    }
}
