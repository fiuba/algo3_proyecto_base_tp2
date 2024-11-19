package edu.fiuba.algo3.entrega_2.parserRondaTienda;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Parser {

    public static List<Map<String, Object>> parsearRondas(String filePath) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al parsear el archivo JSON", e);
        }
    }
}
