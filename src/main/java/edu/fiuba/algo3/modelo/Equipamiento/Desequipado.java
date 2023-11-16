package edu.fiuba.algo3.modelo.Equipamiento;

public class Desequipado implements Equipamiento{
    public Equipamiento mejorarEquipamiento() {
        return new Casco();
    }
}
