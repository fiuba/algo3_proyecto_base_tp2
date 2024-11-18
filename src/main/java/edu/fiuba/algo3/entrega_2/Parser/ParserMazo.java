package edu.fiuba.algo3.entrega_2.Parser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ParserMazo {

    public static List<FakeCarta> convertirDeJsonAFakeCartas(String direccionDeJson) {
        List<FakeCarta> cartas = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(direccionDeJson)) {
            Type tipoLista = new TypeToken<List<FakeCarta>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            throw new ErrorAlParsearJson();
        }
    }



    public static List<Carta> parsearDeFakeCartaACarta(List<FakeCarta> fakeCartas){
        List<Carta> cartas = new ArrayList<>();

        for (FakeCarta fakeCarta : fakeCartas) {
            Palo palo = PaloFactory.crearPalo(fakeCarta.palo);
            int valor = traducirNumeroACarta(fakeCarta.numero);
            Carta carta = new Carta(palo, valor, fakeCarta.puntos);
            cartas.add(carta);
        }
        return cartas;
    }

    private static int traducirNumeroACarta(String numero) {
        switch (numero) {
            case "As": return 11;
            case "K": return 14;
            case "Q": return 13;
            case "J": return 12;
            default: return Integer.parseInt(numero);
        }
    }
}




