package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;

public class Llave implements Equipamiento, Afectante {
    private static final int DANIO = 0;
    public Equipamiento mejorarEquipamiento() {
        return this;
    }

    public void afectar(Jugador jugador) {

    }
    public int recibirAtaque(){
        return DANIO;
    }
}
