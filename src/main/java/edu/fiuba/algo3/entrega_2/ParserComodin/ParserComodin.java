package edu.fiuba.algo3.entrega_2.ParserComodin;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.entrega_2.Parser.ErrorAlParsearJson;
import edu.fiuba.algo3.entrega_2.Comodin.Comodin;
import edu.fiuba.algo3.entrega_2.Comodin.Activacion;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParserComodin {

    public static List<ComodinParseado> convertirDeJsonAFakeComodin(String direccionDeJson) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(direccionDeJson)) {
            Type comodin =  new TypeToken<List<ComodinParseado>>(){}.getType();
            List<ComodinParseado> comodines = gson.fromJson(reader, comodin);

            return comodines;
        } catch (IOException e) {
            throw new ErrorAlParsearJson();
        }
    }



    public static List<Comodin> parsearDeFakeComodinAComodin(List<ComodinParseado> fakeComodines) {
        List<Comodin> comodines = new ArrayList<>();

        for (ComodinParseado fakeComodin : fakeComodines) {
            String nombreStr = fakeComodin.getNombre();
            String puntosStr = fakeComodin.getPuntos();
            String multiplicadorStr = fakeComodin.getMultiplicador();
            String descripcion= fakeComodin.getDescripcion();
            Object activacionData = fakeComodin.getActivacion();  // Activación que puede ser un String o un Map
            int puntos = Integer.parseInt(puntosStr);
            int multiplicador = Integer.parseInt(multiplicadorStr);
            Activacion activacion = ActivacionFactory.crearActivacion(activacionData);
            Comodin comodin = new Comodin(nombreStr, descripcion,puntos, multiplicador, activacion);

            comodines.add(comodin);
        }

        return comodines;
    }

}





