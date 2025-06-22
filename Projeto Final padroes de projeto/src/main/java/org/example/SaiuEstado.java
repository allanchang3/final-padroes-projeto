package org.example;

public class SaiuEstado extends PedidoEstado {

    private static SaiuEstado instance = new SaiuEstado();

    private SaiuEstado() {
    }

    public static SaiuEstado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido saiu para entrega!";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(CanceladoEstado.getInstance());
        return true;
    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(EntregueEstado.getInstance());
        return true;
    }
}
