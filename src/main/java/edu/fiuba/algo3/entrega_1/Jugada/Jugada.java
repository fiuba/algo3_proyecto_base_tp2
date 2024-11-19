package edu.fiuba.algo3.entrega_1.Jugada;

import edu.fiuba.algo3.entrega_1.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import edu.fiuba.algo3.entrega_1.definidorDeManoDePoker.DefinidorDeManoDePoker;

import java.util.ArrayList;


public class Jugada {
    private ArrayList<Carta> cartas;
    private ManoDePoker manoDePoker = new CartaMasAlta();
    private DefinidorDeManoDePoker definidor;

    public Jugada(){
        this.cartas = new ArrayList<Carta>();
        this.definidor = new DefinidorDeManoDePoker();
    }
    public void seleccionar(Carta carta){
        this.cartas.add(carta);
        OrdenadorDeCartas.ordenarCartas(this.cartas);
        definirManoDePoker();
    }

    public Carta deseleccionar(Carta carta){
        this.cartas.remove(carta);  //devuleve la carta para que la mano la vuelva a guadar en su array
        definirManoDePoker();
        return carta;
    }

    private void definirManoDePoker(){
        this.manoDePoker = this.definidor.definirManoDePoker(this.cartas);
    }

    public int cantidadDeCartas(){
        return this.cartas.size();
    }

    public ManoDePoker jugar(){
        this.manoDePoker.jugar(this.cartas);
        this.cartas.clear();
        return this.manoDePoker;
    }

    public void descartar(){
        this.cartas.clear();
    }

    public boolean tieneMano(ManoDePoker otraManoDePoker){
        return this.manoDePoker.equals(otraManoDePoker);
    }
}
