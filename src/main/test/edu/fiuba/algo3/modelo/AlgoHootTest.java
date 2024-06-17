package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoHootTest {

    @Test
    public void test01AgregarJugador() throws ArchivoInexistente {
        //Arrange
        AlgoHoot algoHoot = AlgoHoot.getInstancia();

        // Act
        Jugador jugador1 = new Jugador("Jugador1");

        algoHoot.agregarJugador(jugador1);

        Jugador jugadorObtenido = (Jugador) ((LinkedList) algoHoot.obtenerJugadores()).getLast();
        // Assert
        assertEquals(jugador1.obtenerNombre(), jugadorObtenido.obtenerNombre());
    }

    @Test
    public void test02obtenerPreguntaNoEspecifica() throws ArchivoInexistente {
        // Arrange
        AlgoHoot algoHoot = AlgoHoot.getInstancia();



        // Act
        Pregunta pregunta = algoHoot.obtenerPreguntaActual();
        //System.out.println(pregunta.getPregunta());

        // Assert
        assertNotNull(pregunta);
    }
}
