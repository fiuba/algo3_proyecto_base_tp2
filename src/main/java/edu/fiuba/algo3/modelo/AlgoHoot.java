package edu.fiuba.algo3.modelo;

public class AlgoHoot {

    private static AlgoHoot instancia;

    private AlgoHoot() {}

    public static AlgoHoot getInstancia() {
        if (instancia == null) {
            instancia = new AlgoHoot();
        }
        return instancia;
    }
}
