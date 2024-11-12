package edu.fiuba.algo3.entrega_1.Valor;

public class As extends Valor {

    public As() {
        this.valor = 11;
    }

    @Override
    public boolean esMayor(Valor valor) {
        Boolean lugarDeAs = false;
        if (valor instanceof Dos) {
            lugarDeAs = true;
        }
        return lugarDeAs;
    }
}
