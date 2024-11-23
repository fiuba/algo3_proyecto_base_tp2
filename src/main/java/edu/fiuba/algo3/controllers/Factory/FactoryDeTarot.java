package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.controllers.Parser.ParserMazo;
import edu.fiuba.algo3.controllers.Parser.ParserTarot;
import edu.fiuba.algo3.controllers.Parser.TarotParseado;
import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeTarots;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class FactoryDeTarot implements ProveedorDeTarots {
    private String ruta;
    public FactoryDeTarot(String ruta){
        this.ruta = ruta;
    }

    @Override
    public List<Tarot> generarTarots() {
        List<TarotParseado> tarotsFake = ParserTarot.convertirDeJsonAFakeTarot(this.ruta);
        List<Tarot> tarots = ParserTarot.parsearDeFakeTarotATarot(tarotsFake);
        return tarots;
    }
}
