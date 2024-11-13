/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.fiuba.algo3.entrega_1.carta;


import edu.fiuba.algo3.entrega_1.Palo.Palo;


public class Carta {
    private Palo palo;
    private int valor;

    public Carta(Palo palo, int valor){
           if(valor < 2 || valor > 14){
               throw new ValorDeCartaInvalido();
           }
           this.palo = palo;
           this.valor = valor;
    }


    public boolean esMayor(Carta otraCarta) {
        return otraCarta.valor > this.valor;
    }

    public Boolean sonMismoPalo(Carta otraCarta) {
        return otraCarta.compararPaloCon(this.palo);
    }

    public boolean compararPaloCon(Palo palo) {
        return this.palo.sonMismoPalo(palo);
    }

    public Boolean esIgualA(Carta otraCarta) {
        return otraCarta.valor == this.valor;
    }

    public int getValor(){
        return this.valor.getValor();
    }
}
