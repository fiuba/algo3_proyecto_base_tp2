/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.fiuba.algo3.entrega_1.carta;


import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.Valor.Valor;

public class Carta {
    private Palo palo;
    private Valor valor;

    public Carta(Palo palo, Valor valor){
        this.palo = palo;
        this.valor = valor;
    }


    public boolean compararValor(Carta otraCarta) {
        return otraCarta.compararValorCon(this.valor);
    }

    public boolean compararValorCon(Valor otroValor) {
        return this.valor.compararValor(otroValor);
    }

}
