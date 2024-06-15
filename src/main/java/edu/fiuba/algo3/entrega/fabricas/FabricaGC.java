package edu.fiuba.algo3.entrega.fabricas;

import edu.fiuba.algo3.entrega.*;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FabricaGC implements Fabrica{
    @Override
    public Pregunta crearPregunta(JSONObject datos) {
        String pregunta = datos.getString("Pregunta");
        String respuesta = datos.getString("Respuesta");
        String datosA = "";
        String datosB = "";

        String[] partes = respuesta.split(";");

        for(String parte: partes){
            parte = parte.trim();
            if(parte.startsWith("A:")){
                datosA = parte.substring(2).trim();
            }else {
                datosB = parte.substring(2).trim();
            }
        }

        String[] datosGrupoA = datosA.split(",");
        String[] datosGrupoB = datosB.split(",");

        List<String> opcionesA = new ArrayList<>();
        List<String> opcionesB = new ArrayList<>();

        for(String opcionA: datosGrupoA){
            String opcionActual = datos.getString("Opcion "+opcionA);
            opcionesA.add(opcionActual);
        }
        for(String opcionB: datosGrupoB){
            String opcionActual = datos.getString("Opcion "+opcionB);
            opcionesB.add(opcionActual);
        }

        String nuevosDatosA = String.valueOf(Arrays.toString(opcionesA.toArray()));
        String nuevosDatosB = String.valueOf(Arrays.toString(opcionesA.toArray()));
        Grupo grupoA = new Grupo(nuevosDatosA);
        Grupo grupoB = new Grupo(nuevosDatosB);

        Pregunta nuevaPregunta = new PreguntaGC(pregunta,grupoA,grupoB);

        return nuevaPregunta;
    }
}
