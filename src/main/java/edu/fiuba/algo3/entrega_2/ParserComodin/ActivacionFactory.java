package edu.fiuba.algo3.entrega_2.ParserComodin;
import edu.fiuba.algo3.entrega_2.Comodin.*;
import edu.fiuba.algo3.entrega_2.Parser.ErrorAlCrearPalo;
import java.util.Map;


public class ActivacionFactory {
    public static Activacion crearActivacion(Object activacion) {
        if (activacion instanceof String) {
            return crearActivacionDesdeString((String) activacion);
        } else if (activacion instanceof Map) {
            Map<String, String> activacionMap = (Map<String, String>) activacion;
            return crearActivacionDesdeMap(activacionMap);
        }
    }

    public static Activacion crearActivacionDesdeString(String tipo) {
        switch (tipo) {
            case "Descarte":
                return new ActivacionDescarte();
            case "Siempre":
                return new ActivacionSiempre();
        }
    }

        private static Activacion crearActivacionDesdeMap(Map<String, String> activacionMap) {
            if (activacionMap.containsKey("Mano Jugada")) {
                String valor = activacionMap.get("Mano Jugada");
                return new ActivacionManoDePoker(valor);
            }
            if (activacionMap.containsKey("1 en")) {
                String valor = activacionMap.get("1 en");
                return new ActivacionManoDePoker(valor);
            }

        }
}

