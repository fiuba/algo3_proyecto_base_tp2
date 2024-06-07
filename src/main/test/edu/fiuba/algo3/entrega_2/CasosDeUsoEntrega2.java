package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.entrega.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntrega2 {

    @Test
    public void testMCParcialRespuestaCorrecta() {
        // Arrange
        PreguntaMCParcial p = new PreguntaMCParcial("Animal alado?",
        new OpcionCorrecta("Pato"),
        new OpcionCorrecta("Aguila"),
        new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(2);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Pato"), new Respuesta("Aguila") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCParcialRespuestaIncorrecta() {
        // Arrange
        PreguntaMCParcial p = new PreguntaMCParcial("Animal alado?",
        new OpcionCorrecta("Pato"),
        new OpcionCorrecta("Aguila"),
        new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Perro"), new Respuesta("Aguila") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCParcialRespuestaParcial() {
        // Arrange
        PreguntaMCParcial p = new PreguntaMCParcial("Animal alado?",
        new OpcionCorrecta("Pato"),
        new OpcionCorrecta("Aguila"),
        new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    
    @Test
    public void testOCRespuestaCorrecta() {
        // Arrange
        PreguntaOC p = new PreguntaOC("Ordenar en altura creciente",
        new Orden("Obelisco", "Torre Eiffel", "Burj Khalifa"));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta( "Obelisco", "Torre Eiffel", "Burj Khalifa" ) );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testOCRespuestaIncorrecta() {
        // Arrange
        PreguntaOC p = new PreguntaOC("Ordenar en altura creciente",
        new Orden("Obelisco", "Torre Eiffel", "Burj Khalifa"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta( "Torre Eiffel", "Burj Khalifa", "Obelisco") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testGCRespuestaCorrecta() {
        // Arrange
        PreguntaGC p = new PreguntaGC("Agrupar estos jugadores por pais",
        new Grupo("Messi", "Otamendi", "Di Maria"), new Grupo("Benzema", "Mbappe", "Lloris"));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta( new Grupo("Messi", "Otamendi", "Di Maria"), new Grupo("Benzema", "Mbappe", "Lloris") ) );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testGCRespuestaIncorrecta() {
        // Arrange
        PreguntaGC p = new PreguntaGC("Agrupar estos jugadores por pais",
                new Grupo("Messi", "Otamendi", "Di Maria"), new Grupo("Benzema", "Mbappe", "Lloris"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta( new Grupo("Messi", "Di Maria"), new Grupo("Benzema", "Otamendi", "Mbappe", "Lloris") ) );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }
}