package edu.fiuba.algo3.entrega.fabricas;

import edu.fiuba.algo3.entrega.Pregunta;
import org.json.JSONObject;

public interface Fabrica{
    public Pregunta crearPregunta(JSONObject datos);
}