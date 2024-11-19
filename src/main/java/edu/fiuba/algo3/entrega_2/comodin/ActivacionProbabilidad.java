package edu.fiuba.algo3.entrega_2.comodin;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import java.util.Random;
public class ActivacionProbabilidad implements Activacion {
    private int probabilidad;

    public ActivacionProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public boolean esActivable(ManoDePoker mano) {
        Random random = new Random();
        int numeroAObtener = random.nextInt(probabilidad) + 1;
        int numeroGenerado = random.nextInt(probabilidad) + 1;
        return numeroAObtener == numeroGenerado;    }
}