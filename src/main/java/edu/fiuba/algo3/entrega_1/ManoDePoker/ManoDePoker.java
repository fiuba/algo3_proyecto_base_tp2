package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Objects;


public abstract class ManoDePoker {
    protected String nombre;
    protected Puntaje puntaje;
    protected double probabilidad;

    public void jugar(ArrayList<Carta> cartas){
        for (Carta carta : cartas){
            this.puntaje.sumarValorDeUnPuntaje(carta.obtenerPuntaje());
        }

    }

    public int calcularPuntaje(){
        return this.puntaje.calcularPuntaje();
    }
    public Puntaje calcularPuntaje() {
        return this.puntaje;
    }
        ManoDePoker otraManoDePoker = (ManoDePoker) obj;
        return(Objects.equals(nombre,otraManoDePoker.nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }


    public double obtenerProbabilidad(){
        return this.probabilidad;
    }


