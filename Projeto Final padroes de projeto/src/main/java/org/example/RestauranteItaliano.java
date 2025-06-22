package org.example;

public class RestauranteItaliano implements IRestaurante {

    private String nome;

    public RestauranteItaliano() {
        this.nome = "Restaurante Italiano";
    }

    public boolean prepararPedido(Pedido pedido) {
        return pedido.preparar(pedido);
    }

    public boolean sairPedido(Pedido pedido) {
        return pedido.sair(pedido);
    }

    public boolean entregarPedido(Pedido pedido) {
        return pedido.entregar(pedido);
    }

    public boolean cancelarPedido(Pedido pedido) {
        return pedido.cancelar(pedido);
    }

    public String getNome() {
        return nome;
    }
}
