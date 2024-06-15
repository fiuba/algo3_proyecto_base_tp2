package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.entrega.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntrega3 {
    @Test
    public void testUnTurno() {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("cuantos dedos tiene mi mano derecha?",
                new OpcionCorrecta("5"),
                new OpcionIncorrecta("3"));
        Jugador j1 = new Jugador("J1");
        Jugador j2 = new Jugador("J2");
        Jugador j3 = new Jugador("J3");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        Turno turno = new Turno(p);
        int puntosEsperadosJ1 = 2;
        int puntosEsperadosJ2 = -3;
        int puntosEsperadosJ3 = -1;

        // Act
        turno.jugar(j1, new Duplicador(), new ModificadorGlobalBase(), new Respuesta("5"));
        turno.jugar(j2, new Triplicador(), new ModificadorGlobalBase(), new Respuesta("3"));
        turno.jugar(j3, new ModificadorBase(), new ModificadorGlobalBase(), new Respuesta("3"));
        turno.terminar();

        // Assert
        assertEquals( j1.obtenerPuntaje(), puntosEsperadosJ1);
        assertEquals( j2.obtenerPuntaje(), puntosEsperadosJ2);
        assertEquals( j3.obtenerPuntaje(), puntosEsperadosJ3);
    }

    @Test
    public void testGestorDeTurnos() {
        // Arrange

        // Act

        // Assert

    }
}
