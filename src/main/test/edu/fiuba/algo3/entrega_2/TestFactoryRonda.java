package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.entrega_2.parserRondaTienda.Comodin;
import edu.fiuba.algo3.entrega_2.parserRondaTienda.FactoryRonda;
import edu.fiuba.algo3.entrega_2.parserRondaTienda.Ronda;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestFactoryRonda {

    @Test
    public void testCrearRondasDesdeJSON() throws IOException {
        File jsonFile = new File(getClass().getClassLoader().getResource("balatro.json").getFile());

        assertNotNull(jsonFile, "El archivo JSON no fue encontrado.");
        assertTrue(jsonFile.exists(), "El archivo JSON no existe en la ruta especificada.");

        FactoryRonda factoryRonda = new FactoryRonda(jsonFile.getAbsolutePath());

        List<Ronda> rondas = factoryRonda.obtenerTodasLasRondas();

        assertNotNull(rondas, "Las rondas no deberían ser nulas.");
        assertEquals(1, rondas.size(), "Debería haberse creado exactamente una ronda.");

        Ronda ronda = rondas.get(0);
        assertNotNull(ronda.getTienda(), "La tienda de la ronda no debería ser nula.");
        assertNotNull(ronda.getTienda().getTarots(), "La lista de tarots de la tienda no debería ser nula.");
        assertNotNull(ronda.getTienda().getComodines(), "La lista de comodines de la tienda no debería ser nula.");

        // Verificar que los comodines y tarots tengan los valores esperados
        assertEquals(1, ronda.getTienda().getComodines().size(), "Debe haber un comodín.");
        assertEquals(1, ronda.getTienda().getTarots().size(), "Debe haber un tarot.");

        Comodin comodin = ronda.getTienda().getComodines().get(0);
        assertEquals("comodin1", comodin.getNombre(), "El nombre del comodín debería ser 'comodin1'.");

        Tarot tarot = ronda.getTienda().getTarots().get(0);
        assertEquals("tarot1", tarot.getNombre(), "El nombre del tarot debería ser 'tarot1'.");
    }
}
