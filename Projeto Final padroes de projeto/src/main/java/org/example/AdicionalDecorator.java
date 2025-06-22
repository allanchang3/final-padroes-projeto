package org.example;

public abstract class AdicionalDecorator implements Comida {
    protected Comida comida;

    public AdicionalDecorator(Comida comida) {
        this.comida = comida;
    }
}
