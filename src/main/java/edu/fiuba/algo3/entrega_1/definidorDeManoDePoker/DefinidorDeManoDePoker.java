package edu.fiuba.algo3.entrega_1.definidorDeManoDePoker;

import edu.fiuba.algo3.entrega_1.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;

public class DefinidorDeManoDePoker {
    private ArrayList<Carta> cartas;

    public ManoDePoker definirManoDePoker(ArrayList<Carta> arrayDeCartas){
        this.cartas = arrayDeCartas;
        if (this.tieneUnaCarta()){
            return new CartaMasAlta();
        }
        return new CartaMasAlta();
    }

    private boolean tieneUnaCarta(){
        return (this.cartas.size() == 1);
    }


}
