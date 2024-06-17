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

    @Test
    public void test03jugarUnTurno() throws ArchivoInexistente {
        //Arrange
        AlgoHoot algoHoot = AlgoHoot.getInstancia();
        Jugador j1 = new Jugador("J1");
        Jugador j2 = new Jugador("J2");
        Jugador j3 = new Jugador("J3");

        algoHoot.agregarJugador(j1);
        algoHoot.agregarJugador(j2);
        algoHoot.agregarJugador(j3);

        algoHoot.comenzarNuevoTurno();
        int puntosEsperadosJ1 = 1;
        int puntosEsperadosJ2 = 0;
        int puntosEsperadosJ3 = 0;

        System.out.println(algoHoot.obtenerPreguntaActual().getPregunta());
        List<Opcion> opciones = algoHoot.obtenerPreguntaActual().getOpciones();
        for(Opcion opcion : opciones) {
            System.out.println(opcion.getOpcion());
        }

        // Act
        algoHoot.jugarTurno(j1, new ModificadorBase(), new ModificadorGlobalBase(), new Respuesta("Microondas"), new Respuesta("Televisor de tubo CRT"), new Respuesta("Heladera"), new Respuesta("Imanes del delivery"));
        algoHoot.jugarTurno(j2, new ModificadorBase(), new ModificadorGlobalBase(), new Respuesta("Microondas"), new Respuesta("Televisor de tubo CRT"), new Respuesta("Imanes del delivery"), new Respuesta("Heladera"));
        algoHoot.jugarTurno(j3, new ModificadorBase(), new ModificadorGlobalBase(), new Respuesta("Televisor de tubo CRT"), new Respuesta("Microondas"), new Respuesta("Imanes del delivery"), new Respuesta("Heladera"));
        algoHoot.terminarTurno();

        // Assert
        assertEquals(puntosEsperadosJ1, j1.obtenerPuntaje());
        assertEquals(puntosEsperadosJ2, j2.obtenerPuntaje());
        assertEquals(puntosEsperadosJ3, j3.obtenerPuntaje());
    }
}
