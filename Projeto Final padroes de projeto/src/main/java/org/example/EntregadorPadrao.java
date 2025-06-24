package org.example;

public class EntregadorPadrao implements Entregador {
    @Override
    public String preparar() {
        return "Entregador Padrão: Pronto para entrega regular.";
    }
}