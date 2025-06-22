package org.example;

public interface IRestaurante {
    String getNome();

    boolean prepararPedido(Pedido pedido);

    boolean sairPedido(Pedido pedido);

    boolean entregarPedido(Pedido pedido);

    boolean cancelarPedido(Pedido pedido);
}
