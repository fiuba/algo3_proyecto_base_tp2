package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01UnJugadorTiene0DePuntajeNiBienEsInstanciado(){
        //Arrange
        Jugador jugador = new Jugador();
        int puntajeEsperado = 0;

        //Act
        int puntaje = jugador.obtenerPuntaje();

        //Assert
        assertEquals(puntaje, puntajeEsperado);
    }

    @Test
    public void test02(){
        //Arrange
        Jugador jugador = new Jugador();
        int puntajeEsperado = 0;

        //Act
        int puntaje = jugador.obtenerPuntaje();

        //Assert
        assertEquals(puntaje, puntajeEsperado);
    }
}
