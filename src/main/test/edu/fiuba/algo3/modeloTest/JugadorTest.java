package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01UnJugadorTiene0DePuntajeNiBienEsInstanciado(){
        //Arrange
        Jugador jugador = new Jugador();
        int valorEsperado = 0;

        //Act
        Puntaje puntaje = jugador.obtenerPuntaje();
        int valorObtenido = puntaje.calcularValor();

        //Assert
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void test02(){
        //Arrange

        //Act

        //Assert
    }
}
