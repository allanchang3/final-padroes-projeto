package org.example;

public class EntregadorExpress implements Entregador {
    @Override
    public String preparar() {
        return "Entregador Express: Pronto para entrega rápida!";
    }
}