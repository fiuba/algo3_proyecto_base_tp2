package edu.fiuba.algo3.entrega.fabricas;

import edu.fiuba.algo3.entrega.Orden;
import edu.fiuba.algo3.entrega.Pregunta;
import edu.fiuba.algo3.entrega.PreguntaOC;
import org.json.JSONObject;

import java.util.ArrayList;

public class FabricaOC implements Fabrica {
    @Override
    public Pregunta crearPregunta(JSONObject datos){
        String pregunta =  datos.getString("Pregunta");
        String respuesta = datos.getString("Respuesta");
        String[] listaRepuestas = respuesta.split(",");

        ArrayList<String> opciones = new ArrayList<>();
        for(String resp: listaRepuestas){
            String opcionActual = datos.getString("Opcion "+resp);
            opciones.add(opcionActual);
        }
        String[] opcionesNuevas = opciones.toArray(new String[opciones.size()]);
        Orden ordenCorrecto = new Orden(opcionesNuevas);

        Pregunta nuevaPregunta = new PreguntaOC(pregunta,ordenCorrecto);

        return nuevaPregunta;
    }
}