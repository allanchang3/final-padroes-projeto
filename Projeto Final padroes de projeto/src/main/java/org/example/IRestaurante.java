package org.example;

public interface IRestaurante {
    String getNome();

    Comida getUltimaComida();

    boolean prepararPedido(Pedido pedido);

    boolean sairPedido(Pedido pedido);

    boolean entregarPedido(Pedido pedido);

    boolean cancelarPedido(Pedido pedido);
}
