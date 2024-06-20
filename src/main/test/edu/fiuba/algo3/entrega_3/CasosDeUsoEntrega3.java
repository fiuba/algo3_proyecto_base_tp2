package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoEsperado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntrega3 {
    @Test
    public void testUnTurno() throws JugadorNoEsperado {
        // Arrange
        PreguntaVFPenalidad p = new PreguntaVFPenalidad("cuantos dedos tiene mi mano derecha?","SENTIDO COMUN", "La mano derecha de Pat tiene 5 dedos.",
                new OpcionCorrecta("5"),
                new OpcionIncorrecta("3"));
        Jugador j1 = new Jugador("J1");
        Jugador j2 = new Jugador("J2");
        Jugador j3 = new Jugador("J3");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        RondaDePreguntas rondaDePreguntas = new RondaDePreguntas(p, new OrdenDeRonda(jugadores));
        int puntosEsperadosJ1 = 2;
        int puntosEsperadosJ2 = -3;
        int puntosEsperadosJ3 = -1;

        // Act
        rondaDePreguntas.jugar(j1, new Duplicador(), new ModificadorGlobalBase(), new Respuesta("5"));
        rondaDePreguntas.jugar(j2, new Triplicador(), new ModificadorGlobalBase(), new Respuesta("3"));
        rondaDePreguntas.jugar(j3, new ModificadorBase(), new ModificadorGlobalBase(), new Respuesta("3"));
        rondaDePreguntas.terminar();

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
