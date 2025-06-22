package org.example;

public class RestauranteJapones implements IRestaurante {

    private String nome;

    public RestauranteJapones() {
        this.nome = "Restaurante Japonês";
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
