package org.example;

public class AdicionalQueijo extends AdicionalDecorator {

    public AdicionalQueijo(Comida comida) {
        super(comida);
    }

    @Override
    public String getDescricao() {
        return comida.getDescricao() + ", Queijo";
    }

    @Override
    public double getPreco() {
        return comida.getPreco() + 1.5;
    }
}
