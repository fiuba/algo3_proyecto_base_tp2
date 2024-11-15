package entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ComodinTest {
    @Test
    public void test01UsarComodinPuntajeAfectaPuntaje() {
        Comodin comodin = new ComodinPuntaje("A", "B", 0, 8);
        Puntaje puntaje = new Puntaje(1, 3);

        comodin.modificarPuntaje(puntaje);

        assertEquals(27, puntaje.calcularTotal());
    }
}
