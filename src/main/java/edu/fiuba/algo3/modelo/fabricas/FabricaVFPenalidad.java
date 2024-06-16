package edu.fiuba.algo3.modelo.fabricas;

import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaVFPenalidad;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import org.json.JSONObject;

public class FabricaVFPenalidad implements Fabrica {

    @Override
    public Pregunta crearPregunta(JSONObject datos) {
        String pregunta =  datos.getString("Pregunta");
        String respuesta = datos.getString("Respuesta");
        String[] listaRepuestas = respuesta.split(",");

        String opcionCorrecta = listaRepuestas[0];
        OpcionCorrecta opcorrecta;
        OpcionIncorrecta opincorrecta;

        if(opcionCorrecta.equals("1")){
            opcorrecta = new OpcionCorrecta(datos.getString("Opcion 1"));
            opincorrecta = new OpcionIncorrecta(datos.getString("Opcion 2"));
        }else{
            opcorrecta = new OpcionCorrecta(datos.getString("Opcion 2"));
            opincorrecta = new OpcionIncorrecta(datos.getString("Opcion 1"));
        }

        Pregunta nuevaPregunta = new PreguntaVFPenalidad(pregunta,opcorrecta,opincorrecta);

        return nuevaPregunta;
    }
}