package edu.fiuba.algo3.modelo;

import javafx.scene.SceneAntialiasing;

import java.util.Random;

public class Jugador {
    private Gladiador gladiador;
    private int turnos;
    private int casillaActual;

    //private Casilla casilla;

    public Jugador(Gladiador gladiador) {
        this.gladiador = gladiador;
        this.turnos = 0;
        this.casillaActual = 0;
    }

    public Equipamiento equipamientoGladiador(){
        return this.gladiador.equipamientoGladiador();
    }

    public Seniority seniorityGladiador(){
        return this.gladiador.getSeniority();
    }

    public int getTurnos(){
        return this.turnos;
    }

    public int getCasillaActual() {
        return  this.casillaActual;
    }

    public void jugarTurno() {
        int cantidadAAvanzar = this.tirarDado();
        this.avanzar(cantidadAAvanzar);
        this.turnos++;
        this.gladiador.mejorarSeniority(this.turnos);
        this.aumentarEnergiaConSeniority();
    }

    public void aumentarEnergiaConSeniority () {
        this.gladiador.aumentarEnergiaConSeniority();
    }

    public void avanzar(int cantidad){
        this.casillaActual += cantidad;
    }

    public int tirarDado() {
        if (this.gladiador.tieneEnergia()) {
            Random random = new Random();
            return random.nextInt(6) + 1;
        }
        return 0;
    }

    public boolean tieneTurnosIgualA(int cantidad) {
        return (this.turnos == cantidad);
    }

    public boolean energiaIgualA(int energia){
        return this.gladiador.energiaIgualA(energia);
    }

    public boolean estaEnCasilla(int numeroCasilla) {
        return (this.casillaActual == numeroCasilla);
    }

    public void recibirDanio(int danio){
        this.gladiador.disminuirEnergia(danio);
    }

    public void recibirEnergia(int aumentoEnergia){
        this.gladiador.aumentarEnergia(aumentoEnergia);
    }

    public void mejorarEquipamiento() {
        this.gladiador.mejorarEquipamiento();
    }

    public void recibirAtaque(){
        this.gladiador.recibirAtaque();
    }
}
