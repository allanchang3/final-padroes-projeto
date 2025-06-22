package org.example;

public class CanceladoEstado extends PedidoEstado {

    private static CanceladoEstado instance = new CanceladoEstado();

    private CanceladoEstado() {
    }

    public static CanceladoEstado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido cancelado !";
    }
}
