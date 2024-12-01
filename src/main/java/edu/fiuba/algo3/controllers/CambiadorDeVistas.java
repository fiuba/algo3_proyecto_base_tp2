package main.java.edu.fiuba.algo3.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.edu.fiuba.algo3.vistas.escenas.VistaTienda;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CambiadorDeVistas {
    public static void cambiarVistaANuevaRonda(Stage stage){
        Juego j = Juego.getInstancia();
        if(j.juegoFinalizado()){
            Scene escena = new VistaFinal(stage,1280,720);
            stage.setScene(escena);
        }else{
            Tienda tienda = j.obtenerTiendaActual();
            Scene escena = crearVista(tienda,stage);
            stage.setScene(escena);
        }
    }

    private static Scene crearVista(Tienda tienda, Stage stage) {
        return new  VistaTienda(stage,1280,720, tienda);

    }
}