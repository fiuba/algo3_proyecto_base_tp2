package edu.fiuba.algo3.modelo.fabricas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Orden;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaOC;
import org.json.JSONObject;

import java.util.ArrayList;

public class FabricaOC implements Fabrica {
    @Override
    public Pregunta crearPregunta(JSONObject datos){
        String pregunta =  datos.getString("Pregunta");
        String respuesta = datos.getString("Respuesta");
        String[] listaRepuestas = respuesta.split(",");

        ArrayList<Opcion> opciones = new ArrayList<>();
        for(String resp: listaRepuestas){
            String opcionActual = datos.getString("Opcion "+resp);
            opciones.add(new Opcion(opcionActual));
        }

        Pregunta nuevaPregunta = new PreguntaOC(pregunta,opciones.toArray(new Opcion[0]));

        return nuevaPregunta;
    }
}