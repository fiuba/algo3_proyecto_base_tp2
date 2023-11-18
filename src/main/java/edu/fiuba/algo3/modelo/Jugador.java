package edu.fiuba.algo3.modelo;


//Decorator pattern para equipamiento ?¿
public class Jugador{
    private Gladiador gladiador;
    private int turnos;
    private int casillaActual;

    //private Casilla casilla;

    public Jugador(Gladiador gladiador) {
        this.gladiador = gladiador;
        this.turnos = 0;
        this.casillaActual = 0;
    }

    public boolean energiaIgualA(int energia){
        return this.gladiador.energiaIgualA(energia);
    }

    public Equipamiento equipamientoGladiador(){
        return this.gladiador.equipamientoGladiador();
    }

    public void avanzar(){
        //SACAR IF (provisorio)
        if(this.gladiador.tieneEnergia()){
            this.casillaActual++;
            this.turnos++;
        }
    }

    public int getCasillaActual() {
        return  this.casillaActual;
    }

    public void recibirDanio(int danio){
        this.gladiador.disminuirEnergia(danio);
    }

    public void recibirEnergia(int aumentoEnergia){
        this.gladiador.aumentarEnergia(aumentoEnergia);
    }
}