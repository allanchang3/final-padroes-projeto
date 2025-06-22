package org.example;

public class EntregueEstado extends PedidoEstado {

    private static EntregueEstado instance = new EntregueEstado();

    private EntregueEstado() {
    }

    public static EntregueEstado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido entregue !";
    }
}
