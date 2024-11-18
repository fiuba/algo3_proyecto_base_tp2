package edu.fiuba.algo3.entrega_1.definidorDeManoDePoker;

import edu.fiuba.algo3.entrega_1.ManoDePoker.*;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class DefinidorDeManoDePoker {
    private ArrayList<Carta> cartas;
    private int cantidadDeCartas;

    public ManoDePoker definirManoDePoker(ArrayList<Carta> arrayDeCartas){
        this.cartas = arrayDeCartas;
        this.cantidadDeCartas = this.cartas.size();
        if(this.esEscalera()){
            return definirEscalera();
        }
        else{
            return definirManoComparable();
        }

    }

    private ManoDePoker definirManoComparable(){
        int cantidadDeRepetidas = 0;
        for(int indice = 0; indice <= this.cantidadDeCartas; indice ++){
            int repeticiones = Collections.frequency(this.cartas,this.cartas.get(indice));
            if(repeticiones >= 2){ //necesito que se dos cartas sean iguales si su valor (ej: uno,k) es el mismo
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
        //si no es ninguna de las anterirores debe ser color
        return new Color();
    }


    private boolean esEscalera(){
        //necesito un metodo que me diga si dos valores son seguidos
        Carta cartaAnterior = this.cartas.get(0);
        Carta cartaActual;
        for(int indice = 1; indice < this.cantidadDeCartas; indice ++){
            cartaActual = this.cartas.get(indice);
            if( !cartaActual.leSigueA(cartaAnterior)){
                return false;
            }
            cartaAnterior = cartaActual;
        }
        return true;
    }
    /*la carta puede tener un atributo "antecesor" para poder saber si la carta que tengo ahora
    le sigue a la carta que tenía antes solo preguntando si la antecesora es la carta ya obtenida
    y responde con un booleano
     */

    private ManoDePoker definirEscalera(){
        if(this.cartas.get(0).esAs()){ //crear un metodo en carta que nos diga si es as
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

    private boolean mismoColor(){
        Carta cartaComparadora = this.cartas.get(0);
        for(int indice = 1; indice <= this.cantidadDeCartas; indice ++){
            if(!this.cartas.get(indice).sonMismoPalo(cartaComparadora)){
                return false;
            }
        }
        return true;
    }

}
