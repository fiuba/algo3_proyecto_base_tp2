package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;

public class Gladiador {
    //Declaramos constantes ?
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;


    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;

    public Gladiador() {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
    }

    public void aumentarEnergia(int energia) {
        this.energia += energia;
    }

    public void disminuirEnergia(int energia) {
        this.energia -= energia;
    }

    public boolean energiaIgualA(int energia) {
        return this.energia == energia;
    }

    public boolean tieneEnergia(){
        return this.energia > SIN_ENERGIA;
    }

    public Equipamiento equipamientoGladiador(){
        return this.equipamiento;
    }



}
