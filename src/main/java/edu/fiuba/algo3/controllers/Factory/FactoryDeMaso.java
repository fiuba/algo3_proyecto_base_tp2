package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeCartas;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.controllers.Parser.CartaParseada;
import edu.fiuba.algo3.controllers.Parser.ParserMazo;

import java.util.List;

public class FactoryDeMaso implements ProveedorDeCartas {
    String ruta;

    public FactoryDeMaso(String ruta) {
        this.ruta = ruta;
    }


    @Override
    public List<Carta> generarCartas() {
        List<CartaParseada> cartasFake = ParserMazo.convertirDeJsonAFakeCartas(this.ruta);
        List<Carta> cartas = ParserMazo.parsearDeFakeCartaACarta(cartasFake);
        return cartas;
    }
}
