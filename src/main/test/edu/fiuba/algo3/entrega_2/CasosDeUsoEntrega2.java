package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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
                new Opcion("Obelisco"),
                new Opcion("Torre Eiffel"),
                new Opcion("Burj Khalifa") );
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder(
                new Respuesta("Obelisco"),
                new Respuesta("Torre Eiffel"),
                new Respuesta("Burj Khalifa" ) );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testOCRespuestaIncorrecta() {
        // Arrange
        PreguntaOC p = new PreguntaOC("Ordenar en altura creciente",
                new Opcion("Obelisco"),
                new Opcion("Torre Eiffel"),
                new Opcion("Burj Khalifa") );
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder(
                new Respuesta("Torre Eiffel"),
                new Respuesta("Burj Khalifa" ),
                new Respuesta( "Obelisco") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testGCRespuestaCorrecta() {
        // Arrange
        PreguntaGC p = new PreguntaGC("Agrupar estos jugadores por pais",
                new Grupo(new Opcion("Messi"), new Opcion("Otamendi"), new Opcion("Di Maria")),
                new Grupo(new Opcion("Benzema"), new Opcion("Mbappe"), new Opcion("Lloris")));
        Puntaje puntosEsperados = new Puntaje(1);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Messi"), new Respuesta("Otamendi"), new Respuesta("Di Maria") );

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testGCRespuestaIncorrecta() {
        // Arrange
        PreguntaGC p = new PreguntaGC("Agrupar estos jugadores por pais",
                new Grupo(new Opcion("Messi"), new Opcion("Otamendi"), new Opcion("Di Maria")),
                new Grupo(new Opcion("Benzema"), new Opcion("Mbappe"), new Opcion("Lloris")));
        Puntaje puntosEsperados = new Puntaje(0);

        // Act
        Puntaje puntosObtenidos = p.responder( new Respuesta("Messi"), new Respuesta("Otamendi"));

        // Assert
        assertEquals( puntosObtenidos, puntosEsperados );
    }

    @Test
    public void testVFPenalidadConMultiplicadores() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(2);
        Puntaje puntosEsperadosJ2 = new Puntaje(-2);

        // Act
        ModificadorIndividual multiJ1 = new Duplicador();
        ModificadorIndividual multiJ2 = new Duplicador();
        Puntaje puntosJ1 = p.responder( new Respuesta("Si") );
        puntosJ1.agregarModificador(multiJ1);
        Puntaje puntosJ2 = p.responder( new Respuesta("No") );
        puntosJ2.agregarModificador(multiJ2);


        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos());
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos());
    }

    @Test
    public void testMCPenalidadConMultiplicadores() {
        // Arrange
        PreguntaMCPenalidad p = new PreguntaMCPenalidad("Animal alado?",
                new OpcionCorrecta("Pato"),
                new OpcionCorrecta("Aguila"),
                new OpcionIncorrecta("Perro"));
        Puntaje puntosEsperadosJ1 = new Puntaje(0);
        Puntaje puntosEsperadosJ2 = new Puntaje(3);


        // Act
        ModificadorIndividual multiJ1 = new Duplicador();
        ModificadorIndividual multiJ2 = new Triplicador();
        Puntaje puntosJ1 = p.responder( new Respuesta("Pato"), new Respuesta("Perro") );
        puntosJ1.agregarModificador(multiJ1);
        Puntaje puntosJ2 = p.responder( new Respuesta("Aguila") );
        puntosJ2.agregarModificador(multiJ2);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos());
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos());
    }

    @Test
    public void testUnJugadorUsaAnuladorEnPreguntaVFPenalidad() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(1);
        Puntaje puntosEsperadosJ2 = new Puntaje(0);
        Jugador j1 = new Jugador("j1");
        Jugador j2 = new Jugador("j2");

        // Act
        Anulador anuladorJ1 = new Anulador(j1);

        Puntaje puntosJ1 = p.responder( new Respuesta("Si") );
        puntosJ1.establecerJugador(j1);
        Puntaje puntosJ2 = p.responder( new Respuesta("Si") );
        puntosJ2.establecerJugador(j2);
        List<Puntaje> pts = new ArrayList<Puntaje>();
        pts.add(puntosJ1);
        pts.add(puntosJ2);

        anuladorJ1.aplicar(pts);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos() );
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos() );
    }

    @Test
    public void testDosJugadoresUsanAnuladorEnPreguntaVFPenalidad() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(0);
        Puntaje puntosEsperadosJ2 = new Puntaje(0);
        Jugador j1 = new Jugador("j1");
        Jugador j2 = new Jugador("j2");

        // Act
        Anulador anuladorJ1 = new Anulador(j1);
        Anulador anuladorJ2 = new Anulador(j2);

        Puntaje puntosJ1 = p.responder( new Respuesta("Si") );
        puntosJ1.establecerJugador(j1);
        Puntaje puntosJ2 = p.responder( new Respuesta("Si") );
        puntosJ2.establecerJugador(j2);
        List<Puntaje> pts = new ArrayList<Puntaje>();
        pts.add(puntosJ1);
        pts.add(puntosJ2);

        anuladorJ1.aplicar(pts);
        anuladorJ2.aplicar(pts);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos() );
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos() );
    }

    @Test
    public void testUnJugadorUsaExclusividadYSeActivaEnPreguntaVF() {
        // Arrange
        PreguntaVF p = new PreguntaVF("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(2);
        Puntaje puntosEsperadosJ2 = new Puntaje(0);

        // Act
        Exclusividad exclusividad = new Exclusividad();

        Puntaje puntosJ1 = p.responder( new Respuesta("Si") );
        Puntaje puntosJ2 = p.responder( new Respuesta("No") );
        List<Puntaje> pts = new ArrayList<Puntaje>();
        pts.add(puntosJ1);
        pts.add(puntosJ2);

        exclusividad.aplicar(pts);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos() );
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos() );
    }

    @Test
    public void testUnJugadorUsaExclusividadYNoActivaEnPreguntaVF() {
        // Arrange
        PreguntaVF p = new PreguntaVF("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(0);
        Puntaje puntosEsperadosJ2 = new Puntaje(0);

        // Act
        Exclusividad exclusividad = new Exclusividad();

        Puntaje puntosJ1 = p.responder( new Respuesta("No") );
        Puntaje puntosJ2 = p.responder( new Respuesta("No") );
        List<Puntaje> pts = new ArrayList<Puntaje>();
        pts.add(puntosJ1);
        pts.add(puntosJ2);
        exclusividad.aplicar(pts);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos() );
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos() );
    }
    @Test
    public void testDosJugadoresUsanExclusividadYSeActivanEnPreguntaVF() {
        // Arrange
        PreguntaVF p = new PreguntaVF("1 + 1 = 2?", new OpcionCorrecta("Si"), new OpcionIncorrecta("No") );
        Puntaje puntosEsperadosJ1 = new Puntaje(4);
        Puntaje puntosEsperadosJ2 = new Puntaje(0);

        // Act
        Exclusividad exclusividadJ1 = new Exclusividad();
        Exclusividad exclusividadJ2 = new Exclusividad();

        Puntaje puntosJ1 = p.responder( new Respuesta("Si") );
        Puntaje puntosJ2 = p.responder( new Respuesta("No") );
        List<Puntaje> pts = new ArrayList<Puntaje>();
        pts.add(puntosJ1);
        pts.add(puntosJ2);
        exclusividadJ1.aplicar(pts);
        exclusividadJ2.aplicar(pts);

        // Assert
        assertEquals( puntosJ1.obtenerPuntos(), puntosEsperadosJ1.obtenerPuntos() );
        assertEquals( puntosJ2.obtenerPuntos(), puntosEsperadosJ2.obtenerPuntos() );
    }
}