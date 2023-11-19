package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Jugador;

public class Comida implements Afectante {
    private int aumentoEnergia;

    public Comida() {
        this.aumentoEnergia = 15;
    }
    public void afectar(Jugador jugador) {
        jugador.recibirEnergia(this.aumentoEnergia);
    }
}
