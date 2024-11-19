package edu.fiuba.algo3.entrega_2;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Comodin> comodines;
    private List<Tarot> tarots;

    public Tienda(List<Tarot> tarots, List<Comodin> comodines) {
        this.comodines = comodines;
        this.tarots = tarots;
    }
    public List<Comodin> getComodines() {
        return comodines;
    }

    public List<Tarot> getTarots() {
        return tarots;
    }

    // supuesto: en la tienda no se repiten cartas especiales
    public void seleccionar(Comodin comodinSeleccionado) {
        comodines.removeIf(comodin -> comodin.esElNombre(comodinSeleccionado.getNombre()));
    }

    public void seleccionar(Tarot tarotSeleccionado) {
        tarots.removeIf(tarot -> tarot.esElNombre(tarotSeleccionado.getNombre()));
    }

}
