package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.Random;


public class Bacanal implements Afectante {

    private static final int CANTIDAD_COPAS_TOTAL = 6;
    private static final int ENERGIA_POR_COPA = 4;

    private Random random = new Random();

    public void afectar(Jugador jugador){
        //Deberiamos implementar un dado ¿?
        int cantidadCopas = random.nextInt(CANTIDAD_COPAS_TOTAL) + 1;
        jugador.recibirDanio(ENERGIA_POR_COPA * cantidadCopas);
    }

}
