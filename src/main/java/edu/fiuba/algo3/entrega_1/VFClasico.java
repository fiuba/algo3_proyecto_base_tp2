package edu.fiuba.algo3.entrega_1;

public class VFClasico implements TipoVF{
    @Override
    public int devolverPuntaje(Boolean acierta) {
        return acierta ? 1 : 0;
    }
}
