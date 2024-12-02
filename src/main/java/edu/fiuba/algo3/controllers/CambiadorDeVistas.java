package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.activacion.Activacion;
import edu.fiuba.algo3.modelo.activacion.ActivacionManoDePoker;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.efectos.AumentarPuntaje;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.vistas.escenas.VistaTienda;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.ManoDePoker.Par;

public class CambiadorDeVistas {
    public static void cambiarVistaANuevaRonda(Stage stage){
    /*    Juego j = Juego.getInstancia();
        if(j.juegoFinalizado()){
            Scene escena = new VistaFinal(stage,1280,720);
            stage.setScene(escena);
        }else{
            Tienda tienda = j.obtenerTiendaActual();
            Scene escena = crearVista(tienda,stage);
            stage.setScene(escena);
        } */
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));

        ArrayList<Tarot> tarots = new ArrayList<Tarot>();
        tarots.add( new Tarot("El Tonto", "Mejora la mano carta mas alta", new Puntaje(10, 2), new Modificador("carta mas alta")));
        tarots.add( new Tarot("El Mago", "Mejora la mano par", new Puntaje(15, 2), new Modificador("par")));
        tarots.add( new Tarot("La Emperatriz", "Mejora 1 carta seleccionada y la convierte en una multicarta", new Puntaje(1, 4), new Modificador("carta")));

        ArrayList<Comodin> comodines = new ArrayList<Comodin>();
        Puntaje puntaje1 = new Puntaje(50,1);

        ArrayList<Activacion> activaciones =  new ArrayList<Activacion>();
        activaciones.add(new ActivacionManoDePoker(new Par()));

        comodines.add( new Comodin("Comodin Astuto", "+50  fichas si la mano jugada contiene un par", new AumentarPuntaje(puntaje1) , activaciones));

        Tienda tienda = new Tienda(tarots, comodines, cartas);

        Scene escena = crearVista(tienda,stage);
        stage.setScene(escena);

    }

    private static Scene crearVista(Tienda tienda, Stage stage) {
        return new  VistaTienda(stage,1280,720, tienda);
    }
}