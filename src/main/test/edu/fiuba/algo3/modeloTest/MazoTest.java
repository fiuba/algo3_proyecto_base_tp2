package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.mano.*;
import edu.fiuba.algo3.modelo.mazo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MazoTest {
    @Test
    public void test01UnMazoAlInstanciarseDebeTenerCicuentaYDosCartas(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 0;
        //Act
        Mano manoMock = mock(Mano.class);
        doNothing().when(manoMock).agregarCarta(any());
        mazo.repartirCartas(52, manoMock);
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test02UnMazoAlSacarleCuarentaYOchoCartasYPedirleCincoDebeLanzarError(){
        //Arrange
        Mazo mazo = new Mazo();
        //Act
        Mano manoMock = mock(Mano.class);
        doNothing().when(manoMock).agregarCarta(any());
        mazo.repartirCartas(48, manoMock);
        //Act / Assert
        assertThrows(CartasInsuficientesException.class, () -> {
            mazo.repartirCartas(5, new Mano(8));
        });
    }
    @Test
    public void test03UnMazoAlSacarleCuarentaLeQuedanDoceCartas(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 12;
        Mano manoMock = mock(Mano.class);
        doNothing().when(manoMock).agregarCarta(any());
        mazo.repartirCartas(40, manoMock);
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test04UnMazoAlSacarleTreitaYCuatroCartasYMezclarTieneCincuentaYDosCartasParaUsar(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;
        Mano manoMock = mock(Mano.class);
        doNothing().when(manoMock).agregarCarta(any());
        mazo.repartirCartas(34, manoMock);
        mazo.mezclar();
        //Act
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
}