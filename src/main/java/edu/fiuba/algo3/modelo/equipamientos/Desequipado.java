package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;

public class Desequipado implements Equipamiento, Afectante {
    public Equipamiento mejorarEquipamiento() {
        return new Casco();
    }
    public void afectar(Jugador jugador) {

    }

}
