package org.example;

public class Hamburguer implements Comida {

    @Override
    public String getDescricao() {
        return "Hambúrguer simples";
    }

    @Override
    public double getPreco() {
        return 10.0;
    }
}
