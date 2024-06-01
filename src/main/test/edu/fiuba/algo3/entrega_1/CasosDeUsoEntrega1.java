package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CasosDeUsoEntrega1 {
    @Test
    public void test01VFClasicoRecibeListaDeRespuestasYAsignaPuntosALosJugadoresQueRespondieronCorrectamente() {

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

        Number puntajeEsperadoJ1 = 1;
        Number puntajeEsperadoJ3 = 1;
        // List<Number> puntajesEsperados = new ArrayList<Number>();
        // puntajesEsperados.add(1);
        // puntajesEsperados.add(0);
        // puntajesEsperados.add(1);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ1 = j1.obtenerPuntaje();
        Number puntajeObtenidoJ3 = j3.obtenerPuntaje();
        // List<Number> puntajesObtenidos = listaJugadores.stream()
        //        .map(Jugador::obtenerPuntaje)
        //        .collect(Collectors.toCollection(ArrayList::new));  // Coleccionar en ArrayList<Number>;

        // Assert
        assertEquals(puntajeEsperadoJ1, puntajeObtenidoJ1);
        assertEquals(puntajeEsperadoJ3, puntajeObtenidoJ3);
    }

    @Test
    public void test02VFClasicoRecibeListaDeRespuestasYAsignaPuntosALosJugadoresQueRespondieronIncorrectamente() {

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

        Number puntajeEsperadoJ2 = 0;
        // List<Number> puntajesEsperados = new ArrayList<Number>();
        // puntajesEsperados.add(1);
        // puntajesEsperados.add(0);
        // puntajesEsperados.add(1);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ2 = j2.obtenerPuntaje();
        // List<Number> puntajesObtenidos = listaJugadores.stream()
        //        .map(Jugador::obtenerPuntaje)
        //        .collect(Collectors.toCollection(ArrayList::new));  // Coleccionar en ArrayList<Number>;

        // Assert
        assertEquals(puntajeEsperadoJ2, puntajeObtenidoJ2);

    }

    @Test
    public void test03MCClasicoRecibeListaDeRespuestasYAsignaPuntosAlJugadorQueRespondioCorrectamente() {

        // Arrange
        List<String> opciones = new ArrayList<String>(); // ["Pato","Perro","Pez","Águila"]
        opciones.add("Pato");   // 0
        opciones.add("Perro");  // 1
        opciones.add("Pez");    // 2
        opciones.add("Águila"); // 3
        List<Number> opcionesCorrectas = new ArrayList<Number>();
        opcionesCorrectas.add(0);
        opcionesCorrectas.add(3);
        TipoMC tipo = new MCClasico(opcionesCorrectas);
        Pregunta pregunta = new PreguntaMC("¿Qué animales pueden volar?","biología",opciones,tipo);
        Number puntajeEsperadoJ1 = 1;
        Turno turno = new Turno(pregunta);

        List<Jugador> listaJugadores = new ArrayList<Jugador>();

        Jugador j1 = spy(new Jugador("j1"));
        List<Number> rta1 = new ArrayList<Number>();
        rta1.add(0);
        rta1.add(3);
        when(j1.obtenerJugada()).thenReturn(rta1);
        listaJugadores.add(j1);

        Jugador j2 = spy(new Jugador("j2"));
        List<Number> rta2 = new ArrayList<Number>();
        rta2.add(0);
        rta2.add(1);
        when(j2.obtenerJugada()).thenReturn(rta2);
        listaJugadores.add(j2);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ1 = j1.obtenerPuntaje();

        // Assert
        assertEquals(puntajeEsperadoJ1, puntajeObtenidoJ1);
    }

    @Test
    public void test04MCClasicoRecibeListaDeRespuestasYAsignaPuntosAlJugadorQueRespondioInorrectamente() {

        // Arrange
        List<String> opciones = new ArrayList<String>(); // ["Pato","Perro","Pez","Águila"]
        opciones.add("Pato");   // 0
        opciones.add("Perro");  // 1
        opciones.add("Pez");    // 2
        opciones.add("Águila"); // 3
        List<Number> opcionesCorrectas = new ArrayList<Number>();
        opcionesCorrectas.add(0);
        opcionesCorrectas.add(3);
        TipoMC tipo = new MCClasico(opcionesCorrectas);
        Pregunta pregunta = new PreguntaMC("¿Qué animales pueden volar?","biología",opciones,tipo);
        Number puntajeEsperadoJ2 = 0;
        Number puntajeEsperadoJ3 = 0;
        Turno turno = new Turno(pregunta);

        List<Jugador> listaJugadores = new ArrayList<Jugador>();

        Jugador j1 = spy(new Jugador("j1"));
        List<Number> rta1 = new ArrayList<Number>();
        rta1.add(0);
        rta1.add(3);
        when(j1.obtenerJugada()).thenReturn(rta1);
        listaJugadores.add(j1);

        Jugador j2 = spy(new Jugador("j2"));
        List<Number> rta2 = new ArrayList<Number>();
        rta2.add(0);
        rta2.add(1);
        when(j2.obtenerJugada()).thenReturn(rta2);
        listaJugadores.add(j2);

        Jugador j3 = spy(new Jugador("j3"));
        List<Number> rta3 = new ArrayList<Number>();
        rta3.add(1);
        rta3.add(2);
        when(j3.obtenerJugada()).thenReturn(rta3);
        listaJugadores.add(j3);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ2 = j2.obtenerPuntaje();
        Number puntajeObtenidoJ3 = j3.obtenerPuntaje();

        // Assert
        assertEquals(puntajeEsperadoJ2, puntajeObtenidoJ2);
        assertEquals(puntajeEsperadoJ3, puntajeObtenidoJ3);
    }

    @Test
    public void test05VFPenalidadRecibeListaDeRespuestasYAsignaPuntosALosJugadoresQueRespondieronCorrectamente() {

        // Arrange
        TipoVF tipo = new VFPenalidad();
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

        Number puntajeEsperadoJ1 = 1;
        Number puntajeEsperadoJ3 = 1;
        // List<Number> puntajesEsperados = new ArrayList<Number>();
        // puntajesEsperados.add(1);
        // puntajesEsperados.add(0);
        // puntajesEsperados.add(1);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ1 = j1.obtenerPuntaje();
        Number puntajeObtenidoJ3 = j3.obtenerPuntaje();
        // List<Number> puntajesObtenidos = listaJugadores.stream()
        //        .map(Jugador::obtenerPuntaje)
        //        .collect(Collectors.toCollection(ArrayList::new));  // Coleccionar en ArrayList<Number>;

        // Assert
        assertEquals(puntajeEsperadoJ1, puntajeObtenidoJ1);
        assertEquals(puntajeEsperadoJ3, puntajeObtenidoJ3);
    }

    @Test
    public void test06VFPenalidadRecibeListaDeRespuestasYAsignaPuntosALosJugadoresQueRespondieronIncorrectamente() {

        // Arrange
        TipoVF tipo = new VFPenalidad();
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

        Number puntajeEsperadoJ2 = -1;
        // List<Number> puntajesEsperados = new ArrayList<Number>();
        // puntajesEsperados.add(1);
        // puntajesEsperados.add(0);
        // puntajesEsperados.add(1);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ2 = j2.obtenerPuntaje();
        // List<Number> puntajesObtenidos = listaJugadores.stream()
        //        .map(Jugador::obtenerPuntaje)
        //        .collect(Collectors.toCollection(ArrayList::new));  // Coleccionar en ArrayList<Number>;

        // Assert
        assertEquals(puntajeEsperadoJ2, puntajeObtenidoJ2);

    }

    @Test
    public void test07MCPenalidadRecibeListaDeRespuestasYAsignaPuntosAlJugadorQueRespondioCorrectamente() {

        // Arrange
        List<String> opciones = new ArrayList<String>(); // ["Pato","Perro","Pez","Águila"]
        opciones.add("Pato");   // 0
        opciones.add("Perro");  // 1
        opciones.add("Pez");    // 2
        opciones.add("Águila"); // 3
        List<Number> opcionesCorrectas = new ArrayList<Number>();
        opcionesCorrectas.add(0);
        opcionesCorrectas.add(3);
        TipoMC tipo = new MCPenalidad(opcionesCorrectas);
        Pregunta pregunta = new PreguntaMC("¿Qué animales pueden volar?","biología",opciones,tipo);
        Number puntajeEsperadoJ1 = 2;
        Turno turno = new Turno(pregunta);

        List<Jugador> listaJugadores = new ArrayList<Jugador>();

        Jugador j1 = spy(new Jugador("j1"));
        List<Number> rta1 = new ArrayList<Number>();
        rta1.add(0);
        rta1.add(3);
        when(j1.obtenerJugada()).thenReturn(rta1);
        listaJugadores.add(j1);

        Jugador j2 = spy(new Jugador("j2"));
        List<Number> rta2 = new ArrayList<Number>();
        rta2.add(0);
        rta2.add(1);
        when(j2.obtenerJugada()).thenReturn(rta2);
        listaJugadores.add(j2);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ1 = j1.obtenerPuntaje();

        // Assert
        assertEquals(puntajeEsperadoJ1, puntajeObtenidoJ1);
    }

    @Test
    public void test08MCPenalidadRecibeListaDeRespuestasYAsignaPuntosAlJugadorQueRespondioIncsorrectamente() {

        // Arrange
        List<String> opciones = new ArrayList<String>(); // ["Pato","Perro","Pez","Águila"]
        opciones.add("Pato");   // 0
        opciones.add("Perro");  // 1
        opciones.add("Pez");    // 2
        opciones.add("Águila"); // 3
        List<Number> opcionesCorrectas = new ArrayList<Number>();
        opcionesCorrectas.add(0);
        opcionesCorrectas.add(3);
        TipoMC tipo = new MCPenalidad(opcionesCorrectas);
        Pregunta pregunta = new PreguntaMC("¿Qué animales pueden volar?","biología",opciones,tipo);
        Number puntajeEsperadoJ2 = 0;
        Number puntajeEsperadoJ3 = -2;
        Turno turno = new Turno(pregunta);

        List<Jugador> listaJugadores = new ArrayList<Jugador>();

        Jugador j1 = spy(new Jugador("j1"));
        List<Number> rta1 = new ArrayList<Number>();
        rta1.add(0);
        rta1.add(3);
        when(j1.obtenerJugada()).thenReturn(rta1);
        listaJugadores.add(j1);

        Jugador j2 = spy(new Jugador("j2"));
        List<Number> rta2 = new ArrayList<Number>();
        rta2.add(0);
        rta2.add(1);
        when(j2.obtenerJugada()).thenReturn(rta2);
        listaJugadores.add(j2);

        Jugador j3 = spy(new Jugador("j3"));
        List<Number> rta3 = new ArrayList<Number>();
        rta3.add(1);
        rta3.add(2);
        when(j3.obtenerJugada()).thenReturn(rta3);
        listaJugadores.add(j3);

        // Act
        turno.jugarTurno(listaJugadores);
        Number puntajeObtenidoJ2 = j2.obtenerPuntaje();
        Number puntajeObtenidoJ3 = j3.obtenerPuntaje();

        // Assert
        assertEquals(puntajeEsperadoJ2, puntajeObtenidoJ2);
        assertEquals(puntajeEsperadoJ3, puntajeObtenidoJ3);
    }
}
