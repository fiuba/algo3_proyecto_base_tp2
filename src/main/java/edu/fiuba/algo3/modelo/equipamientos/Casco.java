package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;

public class Casco implements Equipamiento {
    public Equipamiento mejorarEquipamiento() {
        return new Armadura();
    }
}
