package org.example;

public class CriadoEstado extends PedidoEstado {

    private static CriadoEstado instance = new CriadoEstado();

    private CriadoEstado() {
    }

    public static CriadoEstado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido criado !";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(CanceladoEstado.getInstance());
        return true;
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PreparandoEstado.getInstance());
        return true;
    }
}
