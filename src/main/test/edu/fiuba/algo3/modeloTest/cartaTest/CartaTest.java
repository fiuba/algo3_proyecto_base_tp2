package edu.fiuba.algo3.modeloTest.cartaTest;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.carta.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {
    @Test
    public void test01UnaCartaCreadaConNumero10YPaloCorazonTienePuntaje10(){
        // Arrange
        Carta carta = new Carta(10, new Corazon());
        int valorEsperado = 10;
        // Act
        Puntaje puntajeObtenido = carta.obtenerPuntaje();
        int valorObtenido = (int) puntajeObtenido.calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test02UnaCartaCreadaConNumero10YPaloBastoSabeReconocerOtraCartaDeSuMismoPalo(){
        // Arrange
        Carta cartaBase = new Carta(2, new Trebol());
        Carta cartaAComparar = new Carta(12, new Trebol());
        // Act
        boolean resultadoComparacion = cartaBase.esDelMismoPalo(cartaAComparar);
        // Assert
        assertTrue(resultadoComparacion);
    }
    @Test
    public void test03UnaCartaNoPuedeInstanciadaConNumeroNegativo(){
        // Arrange / Act / Assert
        assertThrows(NumeroInvalidoException.class, () -> {
            new Carta(-1, new Trebol());
        });
    }
    @Test
    public void test04UnaCartaNoPuedeInstanciadaConNumeroIgualA0(){
        // Arrange / Act / Assert
        assertThrows(NumeroInvalidoException.class, () -> {
            new Carta(0, new Trebol());
        });
    }
    @Test
    public void test05UnaCartaNoPuedeInstanciadaConNumeroMayorA13(){
        // Arrange / Act / Assert
        assertThrows(NumeroInvalidoException.class, () -> {
            new Carta(14, new Trebol());
        });
    }
    @Test
    public void test06UnaInstaciaDeCartaDebePoderReconocerSiEsLaMismaCartaQueOtraCartaSiTieneElMismoNumeroYPalo(){
        // Arrange
        Carta carta = new Carta(10, new Corazon());
        // Act
        boolean resultadoComparacion = carta.sos(new Carta(10, new Corazon()));
        // Assert
        assertTrue(resultadoComparacion);
    }
    @Test
    public void test07UnaInstaciaDeCartaDebePoderReconocerSiNoEsLaMismaCartaSiNoTieneElMismoNumero(){
        // Arrange
        Carta carta = new Carta(10, new Corazon());
        // Act
        boolean resultadoComparacion = carta.sos(new Carta(9, new Corazon()));
        // Assert
        assertFalse(resultadoComparacion);
    }
    @Test
    public void test07UnaInstaciaDeCartaDebePoderReconocerSiNoEsLaMismaCartaSiNoTieneElMismoPalo(){
        // Arrange
        Carta carta = new Carta(10, new Corazon());
        // Act
        boolean resultadoComparacion = carta.sos(new Carta(10, new Trebol()));
        // Assert
        assertFalse(resultadoComparacion);
    }
}
