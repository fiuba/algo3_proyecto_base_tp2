package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.Seniority;

public class Novato implements Seniority {
    private  static final int AUMENTO_ENERGIA = 0;

    public Seniority ascender(int turno) {
        if (turno == 8) {
            return new SemiSenior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
