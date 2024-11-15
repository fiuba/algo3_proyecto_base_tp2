package edu.fiuba.algo3.modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.util.ArrayList;

public class LectorJson {
    public ArrayList<Poker> leerCartasDeMazo() {
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

    public ArrayList<Comodin> leerComodines() {
        JSONParser parser = new JSONParser();
        ArrayList<Comodin> cartas = new ArrayList<>();

        try (FileReader reader = new FileReader("src/test/resources/json/comodines.json")) {
            // Parsear el archivo JSON
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            // Iterar por cada sección del JSON
            for (Object key : jsonObject.keySet()) {
                String keyString = (String) key;
                if (keyString.equals("Combinación")) {
                    continue;
                }
                JSONObject section = (JSONObject) jsonObject.get(keyString);
                String descripcion = (String) section.get("descripcion");

                // Procesar comodines
                JSONArray comodines = (JSONArray) section.get("comodines");
                for (int i = 0; i < comodines.size(); i++) {
                    JSONObject comodin = (JSONObject) comodines.get(i);
                    String nombre = (String) comodin.get("nombre");
                    String comodinDescripcion = (String) comodin.get("descripcion");
                    JSONObject efecto = (JSONObject) comodin.get("efecto");
                    int puntos = Math.toIntExact((long) efecto.get("puntos"));
                    int multiplicador = Math.toIntExact((long) efecto.get("multiplicador"));

                    // Activación (puede ser un objeto o una cadena)
                    Object activacionObject = comodin.get("activacion");
                    String activacion;
                    if (activacionObject instanceof String) {
                        activacion = (String) activacionObject;
                    } else if (activacionObject instanceof JSONObject) {
                        // no se
                    }

                    cartas.add(new ComodinPuntaje(nombre, comodinDescripcion, puntos, multiplicador));
                }
            }
        } catch (ParseException e) {
            System.err.println("Error al parsear el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }

        return cartas;
    }
}
