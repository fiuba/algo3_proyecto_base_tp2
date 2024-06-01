package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CasosDeUsoEntrega1 {
    @Test
    public void test01VFClasicoRecibeListaDeRespuestasYAsignaPuntosALosJugadoresCorrectamente() {

        // Arrange
        TipoVF tipo = new VFClasico();
        Pregunta pregunta = new PreguntaVF("1+1=2","matemática",1,tipo);
        Turno turno = new Turno(pregunta);

        Jugador j1 = spy(new Jugador("j1"));
        List<Number> rta1 = new ArrayList<Number>();
        rta1.add(1);
        when(j1.obtenerJugada()).thenReturn(rta1);

        Jugador j2 = spy(new Jugador("j2"));
        List<Number> rta2 = new ArrayList<Number>();
        rta2.add(0);
        when(j2.obtenerJugada()).thenReturn(rta2);

        Jugador j3 = spy(new Jugador("j3"));
        List<Number> rta3 = new ArrayList<Number>();
        rta3.add(1);

        when(j3.obtenerJugada()).thenReturn(rta3);

        List<Jugador> listaJugadores = new ArrayList<Jugador>();
        listaJugadores.add(j1);
        listaJugadores.add(j2);
        listaJugadores.add(j3);

        List<Number> puntajesEsperados = new ArrayList<Number>();
        puntajesEsperados.add(1);
        puntajesEsperados.add(0);
        puntajesEsperados.add(1);

        // Act
        turno.jugarTurno(listaJugadores);
        List<Number> puntajesObtenidos = listaJugadores.stream()
                .map(Jugador::obtenerPuntaje)
                .collect(Collectors.toCollection(ArrayList::new));  // Coleccionar en ArrayList<Number>;

        // Assert
        assertEquals(puntajesEsperados, puntajesObtenidos);
    }
}
