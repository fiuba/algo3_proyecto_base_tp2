package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Jugador;
public class Comida implements Afectante {
    public void afectar(Jugador jugador) {
        jugador.recibirEnergia(15);
    }
}
