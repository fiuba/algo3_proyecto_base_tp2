package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.Seniority;

public class SemiSenior implements Seniority {
    private static final int AUMENTO_ENERGIA = 5;

    public Seniority ascender(int turno) {
        if (turno == 12) {
            return new Senior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
