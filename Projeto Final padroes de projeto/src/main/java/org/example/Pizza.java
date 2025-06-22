package org.example;

public class Pizza implements Comida {

    @Override
    public String getDescricao() {
        return "Pizza simples";
    }

    @Override
    public double getPreco() {
        return 12.0;
    }
}
