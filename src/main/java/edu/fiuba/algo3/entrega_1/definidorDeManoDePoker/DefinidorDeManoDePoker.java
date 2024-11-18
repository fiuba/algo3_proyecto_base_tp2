package edu.fiuba.algo3.entrega_1.definidorDeManoDePoker;

import edu.fiuba.algo3.entrega_1.ManoDePoker.*;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class DefinidorDeManoDePoker {
    private ArrayList<Carta> cartas;

    public ManoDePoker definirManoDePoker(ArrayList<Carta> arrayDeCartas){
        this.cartas = arrayDeCartas;
        if(this.esEscalera()){
            return definirEscalera();
        }
        else{
            return definirManoComparable();
        }

    }

    private ManoDePoker definirManoComparable(){
        int cantidadDeRepetidas = 0;
        for(int indice = 0; indice <= 2; indice ++){
            int repeticiones = Collections.frequency(this.cartas,this.cartas.get(indice));
            if(repeticiones >= 2){ //necesito un método que me diga si 2 cartas son iguales segun el valor o segun el palo
                cantidadDeRepetidas ++ ;
            }
        }
        switch(cantidadDeRepetidas){
            case 0:
                return new CartaMasAlta();

            case 2:
                return new Par();

            case 3:
                return new Trio();

            case 4://veo si es doble par o poker
                return this.definidorDeCuatroRepetidas();

            case 5:
                return new FullHouse();
        }

    }


    private boolean esEscalera(){
        int valorCartaAnterior = this.cartas.get(0).getValor();
        for(int indice = 1; indice < 5; indice ++){
            int valorCartaActual =this.cartas.get(0).getValor();
            if( valorCartaActual != valorCartaAnterior - 1){
                return false;
            }
            valorCartaAnterior = valorCartaActual;
        }
        return true;
    }

    private ManoDePoker definirEscalera(){
        if(this.cartas.get(0).getValor() == 14){ //el valor del As
            return new EscaleraReal();
        }else if(this.mismoColor()){
            return new EscaleraColor();
        }
        return new EscaleraSimple();
    }

    private ManoDePoker definidorDeCuatroRepetidas(){
        int repeticiones = 0;
        for(int indice = 0; indice < 2; indice++){
            repeticiones = Collections.frequency(this.cartas,this.cartas.get(indice));
            if(repeticiones == 2){ return new DoblePar(); }
            else if (repeticiones == 4) { return new Poker(); }
        }
    }


}
