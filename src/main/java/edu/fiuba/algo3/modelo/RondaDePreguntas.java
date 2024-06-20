package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorNoEsperado;

import java.util.ArrayList;
import java.util.List;

public class RondaDePreguntas {
    private Pregunta pregunta;
    private OrdenDeRonda ordenDeRonda;
    private List<PuntajeParcial> puntajes;
    private List<ModificadorGlobal> modificadoresGlobales;

    public RondaDePreguntas(Pregunta pregunta, OrdenDeRonda ordenDeRonda) {
        this.pregunta = pregunta;
        this.puntajes = new ArrayList<PuntajeParcial>();
        this.modificadoresGlobales = new ArrayList<ModificadorGlobal>();
        this.ordenDeRonda = ordenDeRonda;
    }

    public void jugar(Jugador j, ModificadorIndividual modInd, ModificadorGlobal modGlob, Respuesta... respuestas) throws JugadorNoEsperado {

        Jugador jugadorActual = ordenDeRonda.obtenerJugadorActual();

        if(jugadorActual.equals(j)) {


            PuntajeParcial puntos = pregunta.responder(respuestas);

            puntos.establecerJugador(j);

            puntos.agregarModificador(modInd);

            j.gastar(modInd);

            modificadoresGlobales.add(modGlob);

            puntajes.add(puntos);

            ordenDeRonda.avanzarTurno();
        } else {
            throw new JugadorNoEsperado("El jugador obtenido en la respuesta no es el esperado");
        }

    }

    public void terminar() {

        modificadoresGlobales.forEach(m -> m.aplicar(puntajes));

        puntajes.forEach(PuntajeParcial::actualizarPuntajeDelJugador);
    }

    public Pregunta getPregunta() {
        return pregunta;
    }
}
