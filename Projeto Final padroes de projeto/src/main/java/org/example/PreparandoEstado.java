package org.example;

public class PreparandoEstado extends PedidoEstado {

    private static PreparandoEstado instance = new PreparandoEstado();

    private PreparandoEstado() {
    }

    public static PreparandoEstado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido sendo preparado!";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(CanceladoEstado.getInstance());
        return true;
    }

    public boolean sair(Pedido pedido) {
        pedido.setEstado(SaiuEstado.getInstance());
        return true;
    }
}
