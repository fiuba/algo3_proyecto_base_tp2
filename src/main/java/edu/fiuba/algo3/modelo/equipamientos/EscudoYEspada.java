package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;

public class EscudoYEspada implements Equipamiento {
    public Equipamiento mejorarEquipamiento() {
        return new Llave();
    }
}
