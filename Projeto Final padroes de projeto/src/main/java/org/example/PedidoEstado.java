package org.example;

public abstract class PedidoEstado {

    public PedidoEstado() {
    }

    public abstract String getEstado();

    public boolean criar(Pedido pedido) {
        return false;
    }

    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean sair(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
