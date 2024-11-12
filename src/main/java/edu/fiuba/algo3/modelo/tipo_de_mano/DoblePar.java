package edu.fiuba.algo3.modelo.tipo_de_mano;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class DoblePar implements TipoDeMano {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 2) == 2;
    }

    @Override
    public int calcularPuntos() {
        return 20;
    }

    @Override
    public int calcularMultiplicador() {
        return 2;
    }

    @Override
    public TipoDeManoModificada aplicarMultiplicador(int multiplicador){
        TipoDeManoModificada tipoDeMano = new TipoDeManoModificada(this, multiplicador);
        return tipoDeMano;
    }
}