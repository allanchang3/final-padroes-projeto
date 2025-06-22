package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Pedido fazerPedido(String restauranteClassName) {
        IRestaurante restaurante = RestauranteFactory.obterServico(restauranteClassName);
        Pedido pedido = new Pedido(restaurante);
        pedido.addObserver(this);
        pedido.setEstado(CriadoEstado.getInstance());
        pedido.criar(pedido);
        return pedido;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ", " + arg;
    }
}
