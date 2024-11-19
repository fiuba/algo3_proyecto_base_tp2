package edu.fiuba.algo3.entrega_2;

import java.util.List;
import java.util.Map;

public class Comodin {
        private String nombre;
        private String descripcion;
        private Map<String, String> activacion;
        private int  puntos;
        private int  multiplicador;


        public Comodin(String nombre, String descripcion, Map<String, String> activacion, int  puntos, int multiplicador ) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.activacion = activacion;
            this.puntos  = puntos;
            this.multiplicador = multiplicador;
        }

        public String getNombre() {return this.nombre;}

        public boolean esElNombre(String nombre) {return nombre.equals(this.nombre);}

}
