package org.example;

public class RestauranteHamburguer implements IRestaurante {

    private String nome;

    private Comida comidaMontada;

    public RestauranteHamburguer() {
        this.nome = "Restaurante Hamburguer";
    }

    public boolean prepararPedido(Pedido pedido) {
        Comida comida = new Hamburguer();
        comida = new AdicionalBacon(comida);
        comida = new AdicionalQueijo(comida);
        this.comidaMontada = comida;
        System.out.println("Preparando: " + comida.getDescricao() + " - Preço: R$" + comida.getPreco());
        return pedido.preparar(pedido);
    }

    public Comida getUltimaComida(){return this.comidaMontada; };

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
