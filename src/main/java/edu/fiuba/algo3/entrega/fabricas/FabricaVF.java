package edu.fiuba.algo3.entrega.fabricas;

import edu.fiuba.algo3.entrega.OpcionCorrecta;
import edu.fiuba.algo3.entrega.OpcionIncorrecta;
import edu.fiuba.algo3.entrega.Pregunta;
import edu.fiuba.algo3.entrega.PreguntaVF;
import org.json.JSONObject;

public class FabricaVF implements Fabrica{
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
        Pregunta nuevaPregunta = new PreguntaVF(pregunta,opcorrecta,opincorrecta);

        return nuevaPregunta;
    }
}