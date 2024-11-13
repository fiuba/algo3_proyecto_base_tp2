/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.fiuba.algo3.entrega_1.carta;


import edu.fiuba.algo3.entrega_1.Modificable.Modificable;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;


public class Carta implements Modificable {
    private Palo palo;
    private int valor;
    private int multiplicador;

    public Carta(Palo palo, int valor){
           if(valor < 2 || valor > 14){
               throw new ValorDeCartaInvalido();
           }
           this.palo = palo;
           this.valor = valor;
           this.multiplicador = 1;
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


    @Override
    public void aplicarModificacion(int valor) {
        this.valor = valor;
    }

    public Puntaje calcularPuntaje() {
        return new Puntaje(this.valor, this.multiplicador);
    }
}
