package edu.fiuba.algo3.controllers.Factory;
import edu.fiuba.algo3.controllers.Parseados.*;
import edu.fiuba.algo3.controllers.Parser.ParserComodin;
import edu.fiuba.algo3.controllers.Parser.ParserMazo;
import edu.fiuba.algo3.controllers.Parser.ParserJuego;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FactoryRondas {
    String ruta;
    FactoryDeTarot factoryDeTarot;
    FactoryDeMaso factoryDeMaso;
    FactoryComodines factoryComodines;
    ParserComodin parserComodin;


    public FactoryRondas(String ruta, FactoryDeTarot factoryDeTarot, FactoryDeMaso factoryDeMaso, FactoryComodines factoryComodines) {
        this.ruta = ruta;
        this.factoryDeTarot = factoryDeTarot;
        this.factoryDeMaso = factoryDeMaso;
        this.factoryComodines = factoryComodines;
    }


    public List<Ronda> generarRondas() throws IOException {
        List<Ronda> rondas = new ArrayList<>();


        List<Tarot> tarotsGenerados = factoryDeTarot.generarTarots();
        List<Carta> cartasGeneradas = factoryDeMaso.generarCartas();
        List<Comodin> comodinesGenerados = factoryComodines.generarComodines();


        List<RondaParseada> rondasFake = ParserJuego.parseRondas(this.ruta);
        for (RondaParseada fakeRonda : rondasFake) {
            TiendaParseado tiendaFake = fakeRonda.getTienda();


            List<String> nombresTarots = tiendaFake.getTarots() != null
                    ? tiendaFake.getTarots().stream().map(TarotParseado::getNombre).collect(Collectors.toList())
                    : new ArrayList<>();

            List<String> numerosCartas = tiendaFake.getCartas() != null
                    ? tiendaFake.getCartas().stream().map(CartaParseada::getNumero).collect(Collectors.toList())
                    : new ArrayList<>();

            List<String> nombresComodines = tiendaFake.getComodines() != null
                    ? tiendaFake.getComodines().stream().map(ComodinParseado::getNombre).collect(Collectors.toList())
                    : new ArrayList<>();


            List<Tarot> tarotsFiltrados = tarotsGenerados.stream()
                    .filter(tarot -> nombresTarots.contains(tarot.obtenerNombre()))
                    .collect(Collectors.toList());


            List<Carta> cartasFiltradas = cartasGeneradas.stream()
                    .filter(carta -> numerosCartas.contains(carta.obtenerNombre()))
                    .collect(Collectors.toList());


            Set<String> nombresUnicosComodines = new HashSet<>(nombresComodines);
            List<Comodin> comodinesFiltrados = comodinesGenerados.stream()
                    .filter(comodin -> nombresUnicosComodines.contains(comodin.obtenerNombre()))
                    .collect(Collectors.toList());


            Tienda tienda = new Tienda(tarotsFiltrados, comodinesFiltrados, cartasFiltradas);


            Ronda ronda = ParserJuego.parsearDeFakeRondaARonda(fakeRonda, tienda);
            rondas.add(ronda);
        }

        return rondas;
    }
    }




