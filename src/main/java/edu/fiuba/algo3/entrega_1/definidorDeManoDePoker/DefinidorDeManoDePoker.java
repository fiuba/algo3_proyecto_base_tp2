package edu.fiuba.algo3.entrega_1.definidorDeManoDePoker;

import edu.fiuba.algo3.entrega_1.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.ManoDePoker.Par;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class DefinidorDeManoDePoker {
    private ArrayList<Carta> cartas;

    public ManoDePoker definirManoDePoker(ArrayList<Carta> arrayDeCartas){
        this.cartas = arrayDeCartas;
        if (this.tieneUnaCarta()){
            return new CartaMasAlta();
        }
        if(this.tienePares()){
            return new Par();
        }
        return new CartaMasAlta();
    }

    private boolean tieneUnaCarta(){
        return (this.cartas.size() == 1);
    }

    private boolean tienePares(){
        for (int i = 0 ; i >= this.cartas.size()-1;i++){
            if (Collections.frequency(this.cartas,this.cartas.get(i)) == 2 ){
                return true;
            }
        }
        return true; //provisorio;
    }

}
