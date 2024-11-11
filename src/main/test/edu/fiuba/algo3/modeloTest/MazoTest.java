package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.carta.Corazon;
import edu.fiuba.algo3.modelo.mano.*;
import edu.fiuba.algo3.modelo.mazo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MazoTest {
    @Test
    public void test01UnMazoAlInstanciarseDebeTenerCicuentaYDosCartas(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 0;
        //Act
        Mano mano = new Mano(52);
        mazo.repartirCartas(52, mano);
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test02UnMazoAlSacarleCuarentaYOchoCartasYPedirleCincoDebeLanzarError(){
        //Arrange
        Mazo mazo = new Mazo();
        //Act
        Mano mano = new Mano(48);
        mazo.repartirCartas(48, mano);
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
        Mano mano = new Mano(40);
        mazo.repartirCartas(40, mano);
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test04UnMazoAlSacarleTreitaYCuatroCartasYMezclarTieneCincuentaYDosCartasParaUsar(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;
        Mano mano = new Mano(34);
        mazo.repartirCartas(34, mano);
        mazo.mezclar();
        //Act
        int cantidadDeCartasObtenidas = mazo.obtenerCantidadCartasDisponibles();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
}