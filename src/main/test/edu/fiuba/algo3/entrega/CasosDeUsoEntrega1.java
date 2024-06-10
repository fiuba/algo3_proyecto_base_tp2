package edu.fiuba.algo3.entrega;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntrega1 {

    @Test
    public void testVFRespuestaCorrecta() {
        // Arrange
        PreguntaVF p = new PreguntaVF("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Si") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testVFRespuestaIncorrecta() {
        // Arrange
        PreguntaVF p = new PreguntaVF("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("No") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testVFPenalidadRespuestaCorrecta() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Si") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }
    @Test
    public void testVFPenalidadRespuestaIncorrecta() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperados = new Puntaje(-1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("No") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCRespuestaCorrecta() {
        // Arrange
        PreguntaMC p = new PreguntaMC("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"), new Respuesta("Pato") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCRespuestaIncompleta() {
        // Arrange
        PreguntaMC p = new PreguntaMC("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"));

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCRespuestaIncorrecta() {
        // Arrange
        PreguntaMC p = new PreguntaMC("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"), new Respuesta("Perro"));

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCPenalidadRespuestaCorrecta() {
        // Arrange
        PreguntaMCPenalidad p = new PreguntaMCPenalidad("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(2);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"), new Respuesta("Pato") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCPenalidadRespuestaIncompleta() {
        // Arrange
        PreguntaMCPenalidad p = new PreguntaMCPenalidad("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"));

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testMCPenalidadRespuestaIncorrecta() {
        // Arrange
        PreguntaMCPenalidad p = new PreguntaMCPenalidad("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Aguila"), new Respuesta("Perro"));

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

}


