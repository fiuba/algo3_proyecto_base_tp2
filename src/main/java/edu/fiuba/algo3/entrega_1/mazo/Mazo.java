/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.fiuba.algo3.entrega_1.mazo;



import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.entrega_1.carta.Carta;

public class Mazo {
    private List<Carta> mazo = new ArrayList();

    public Mazo(){
        this.mazo = this.generarCartas();
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
        return this.mazo.size();
    }

    public List<Carta> repartir(int cantidad) {
        List<Carta> cartas = new ArrayList();
        for (int i = cantidad; i > 0; i--) {
            Carta carta = this.mazo.get(i);
            cartas.add(carta);
            this.mazo.remove(i);
        }
        return cartas;
    }
}
