package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoEsperado;

import java.util.LinkedList;
import java.util.List;

public class GestorDeTurnos {
    private LinkedList<RondaDePreguntas> rondasDePreguntas;
    private GestorDePreguntas gestorDePreguntas;
    private List<Jugador> jugadores;

    public GestorDeTurnos() {
        this.rondasDePreguntas = new LinkedList<>();
        jugadores = new LinkedList<Jugador>();
    }

    public void inicializarGestorDePreguntas() throws ArchivoInexistente {
        gestorDePreguntas = new GestorDePreguntas();
    }

    public void comenzarNuevaRonda() {
        Pregunta p = gestorDePreguntas.obtenerSiguientePregunta();
        RondaDePreguntas nuevoRondaDePreguntas = new RondaDePreguntas(p, new OrdenDeRonda(this.jugadores));
        rondasDePreguntas.add(nuevoRondaDePreguntas);
    }

    public Pregunta obtenerPreguntaRondaActual(){
        if(rondasDePreguntas.isEmpty()){
            comenzarNuevaRonda();
        }
        return rondasDePreguntas.getLast().getPregunta();
    }

    public void jugarRondaActual(Jugador j, ModificadorIndividual mi, ModificadorGlobal mg, Respuesta... respuestas) throws JugadorNoEsperado {
        RondaDePreguntas rondaDePreguntas = rondasDePreguntas.getLast();

        rondaDePreguntas.jugar(j, mi, mg, respuestas);
    }

    public void terminarRondaActual() {
        RondaDePreguntas rondaDePreguntas = rondasDePreguntas.getLast();
        rondaDePreguntas.terminar();
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }

    public void reiniciarListaDeJugadores(){
        jugadores.clear();
    }
}
