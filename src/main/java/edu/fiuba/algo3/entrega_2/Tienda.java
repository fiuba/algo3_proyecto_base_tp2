package edu.fiuba.algo3.entrega_2;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Comodin> comodines;
    private List<Tarot2> tarots;

    public Tienda(List<Tarot2> tarots, List<Comodin> comodines) {
        this.comodines = comodines;
        this.tarots = tarots;
    }
    public List<Comodin> getComodines() {
        return comodines;
    }

    public List<Tarot2> getTarots() {
        return tarots;
    }

    // supuesto: en la tienda no se repiten cartas especiales
    public void seleccionar(Comodin comodinSeleccionado) {
        comodines.removeIf(comodin -> comodin.esElNombre(comodinSeleccionado.getNombre()));
    }

    public void seleccionar(Tarot2 tarotSeleccionado) {
        tarots.removeIf(tarot -> tarot.esElNombre(tarotSeleccionado.getNombre()));
    }

}
