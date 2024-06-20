package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoEsperado;

import java.util.List;

public class AlgoHoot {

    private static AlgoHoot instancia;

    private GestorDeTurnos gestorDeTurnos;



    private AlgoHoot(){
        gestorDeTurnos = new GestorDeTurnos();


    }

    public static AlgoHoot getInstancia() {
        if (instancia == null) {
            instancia = new AlgoHoot();
        }
        return instancia;
    }



    public void inicializarGestorDePreguntas() throws ArchivoInexistente {
        gestorDeTurnos.inicializarGestorDePreguntas();
    }

    public void comenzarNuevaRondaDePreguntas(){
        gestorDeTurnos.comenzarNuevaRonda();
    }

    public void jugarRondaDePreguntas(Jugador j, List<ModificadorIndividual> mis, List<ModificadorGlobal> mgs, Respuesta... respuestas) throws JugadorNoEsperado {
        gestorDeTurnos.jugarRondaActual(j, mis, mgs, respuestas);
    }

    public void terminarRondaDePreguntas(){
        gestorDeTurnos.terminarRondaActual();
    }

    public Pregunta obtenerPreguntaActual(){
        return gestorDeTurnos.obtenerPreguntaRondaActual();
    }

    public void agregarJugador(Jugador jugador) {
        gestorDeTurnos.agregarJugador(jugador);
    }

    public List<Jugador> obtenerJugadores(){
        return gestorDeTurnos.obtenerJugadores();
    }

    public void reiniciarListaDeJugadores() {
        gestorDeTurnos.reiniciarListaDeJugadores();
    }
}
