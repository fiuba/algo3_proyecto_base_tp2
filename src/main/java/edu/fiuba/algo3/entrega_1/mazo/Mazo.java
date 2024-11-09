/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.fiuba.algo3.entrega_1.mazo;



import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.entrega_1.carta.Carta;

class Mazo {
    private List<Carta> carta = new ArrayList();

    public Mazo(){
        this.carta = this.generarCartas();
    }

    private  List<Carta> generarCartas(){
        List<Carta> cartas = new ArrayList();
        for(int i = 0; i < 52 ;i++){
            Carta carta = new Carta();
            cartas.add(carta);
        }
        return cartas;
    }

    public int cartasRestantes(){
        return this.carta.size();
    }
}
