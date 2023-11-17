package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Jugador;

public class Fiera implements Afectante {

    public void afectar(Jugador jugador) {
        jugador.recibirDanio(20);
    }
}
