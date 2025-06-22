package org.example;

public class AdicionalBacon extends AdicionalDecorator {

    public AdicionalBacon(Comida comida) {
        super(comida);
    }

    @Override
    public String getDescricao() {
        return comida.getDescricao() + ", Bacon";
    }

    @Override
    public double getPreco() {
        return comida.getPreco() + 2.5;
    }
}
