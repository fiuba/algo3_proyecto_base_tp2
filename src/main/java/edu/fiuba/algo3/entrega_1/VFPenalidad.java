package edu.fiuba.algo3.entrega_1;

public class VFPenalidad implements TipoVF {

    public int devolverPuntaje(Boolean acierta) {
        if (acierta) {
            return 1;
        }
        return -1;
    }

}
