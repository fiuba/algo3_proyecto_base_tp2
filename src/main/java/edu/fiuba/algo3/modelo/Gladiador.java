package edu.fiuba.algo3.modelo;
//Energia inicial -> como constante ?
public class Gladiador {
    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;

    public Gladiador() {
        this.energia = 20;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
    }

    public void aumentarEnergia(int energia) {
        this.energia += energia;
    }

    public void disminuirEnergia(int energia) {
        this.energia -= energia;
    }

    public boolean tieneEnergia(int energia) {
        return (this.energia == energia);
    }

}
