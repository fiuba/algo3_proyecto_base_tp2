package edu.fiuba.algo3.modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorJson {
    public ArrayList<Poker> leerCartas() {
        JSONParser parser = new JSONParser();
        ArrayList<Poker> cartas = new ArrayList<>();

        try (FileReader reader = new FileReader("src/test/resources/json/mazo.json")) {
            // Parsear el archivo JSON
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Obtener el array "mazo"
            JSONArray mazo = (JSONArray) jsonObject.get("mazo");

            // Recorrer las cartas del mazo
            for (Object obj : mazo) {
                Poker poker = getPoker((JSONObject) obj);
                cartas.add(poker);
            }
        } catch (ParseException e) {
            System.err.println("Error al parsear el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }

        return cartas;
    }

    private static Poker getPoker(JSONObject obj) {
        JSONObject carta = obj;

        String nombre = (String) carta.get("nombre");
        String paloString = (String) carta.get("palo");
        Palo palo;
        switch (paloString) {
            case "Trebol":
                palo = new Trebol();
                break;
            case "Diamantes":
                palo = new Diamante();
                break;
            case "Corazones":
                palo = new Corazon();
                break;
            case "Picas":
                palo = new Pica();
                break;
            default:
                throw new RuntimeException("Palo inválido");
        }

        String numero = (String) carta.get("numero");
        int puntos = Math.toIntExact((long) carta.get("puntos"));
        int multiplicador = Integer.parseInt((String) carta.get("multiplicador"));
        Poker poker = new Poker(multiplicador, numero, puntos, palo);
        return poker;
    }
}
