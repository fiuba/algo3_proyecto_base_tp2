package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.mano.*;
import edu.fiuba.algo3.modelo.mazo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {
    @Test
    public void test01UnMazoAlInstanciarseDebeTenerCicuentaYDosCartas(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;
        //Act
        int cantidadDeCartasObtenidas = 0;
        for (int i = 1; i <= 6; i++) {
            Mano mano = new Mano(8);
            mazo.repartirCartas(8, mano);
            cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        }
        Mano mano = new Mano(8);
        mazo.repartirCartas(4, mano);
        cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test02UnMazoAlSacarleCuarentaYOchoCartasYPedirleCincoDebeLanzarError(){
        //Arrange
        Mazo mazo = new Mazo();
        //Act
        for (int i = 1; i <= 6; i++) {
            Mano mano = new Mano(8);
            mazo.repartirCartas(8, mano);
        }
        Mano mano = new Mano(8);
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
        int cantidadDeCartasObtenidas = 0;
        for (int i = 1; i <= 5; i++) {
            Mano mano = new Mano(8);
            mazo.repartirCartas(8, mano);
        }
        Mano mano = new Mano(8);
        mazo.repartirCartas(8, mano);
        cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        mano = new Mano(8);
        mazo.repartirCartas(4, mano);
        cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test04UnMazoAlSacarleOchoCartasYMezclarTieneCincuentaYDosCartasParaUsar(){
        //Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;
        Mano mano = new Mano(8);
        mazo.repartirCartas(8, new Mano(8));
        int cantidadDeCartasObtenidas = 0;
        mazo.mezclar();
        //Act
        for (int i = 1; i <= 6; i++) {
            mano = new Mano(8);
            mazo.repartirCartas(8, mano);
            cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        }
        mano = new Mano(8);
        mazo.repartirCartas(4, mano);
        cantidadDeCartasObtenidas += mano.obtenerCantidadDeCartas();
        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
}