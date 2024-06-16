package edu.fiuba.algo3.modelo.fabricas;

import edu.fiuba.algo3.modelo.Pregunta;
import org.json.JSONObject;

public interface Fabrica{
    public Pregunta crearPregunta(JSONObject datos);
}