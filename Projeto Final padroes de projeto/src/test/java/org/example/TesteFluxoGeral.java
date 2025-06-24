package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteFluxoGeral {

    @Test
    void fluxoCompletoDoPedidoUtilizandoRestaurante() {
        Cliente cliente = new Cliente("João");
        Pedido pedido = cliente.fazerPedido("RestauranteHamburguer");

        String esperada1 = "João, Estado do pedido: Pedido criado ! (por Restaurante Hamburguer)";
        Assertions.assertEquals(esperada1, cliente.getUltimaNotificacao());

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        String esperada2 = "João, Estado do pedido: Pedido sendo preparado! (por Restaurante Hamburguer)";
        Assertions.assertEquals(esperada2, cliente.getUltimaNotificacao());
        Assertions.assertSame(PreparandoEstado.getInstance(), pedido.getEstado());

        restaurante.sairPedido(pedido);
        String esperada3 = "João, Estado do pedido: Pedido saiu para entrega! (por Restaurante Hamburguer)";
        Assertions.assertEquals(esperada3, cliente.getUltimaNotificacao());
        Assertions.assertSame(SaiuEstado.getInstance(), pedido.getEstado());

        restaurante.entregarPedido(pedido);
        String esperada4 = "João, Estado do pedido: Pedido entregue ! (por Restaurante Hamburguer)";
        Assertions.assertEquals(esperada4, cliente.getUltimaNotificacao());
        Assertions.assertSame(EntregueEstado.getInstance(), pedido.getEstado());

        boolean cancelamento = restaurante.cancelarPedido(pedido);
        Assertions.assertFalse(cancelamento);
        Assertions.assertSame(EntregueEstado.getInstance(), pedido.getEstado());
    }

    @Test
    void fluxoCanceladoDurantePreparacaoUtilizandoRestaurante() {
        Cliente cliente = new Cliente("Ana");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        IRestaurante restaurante = pedido.getRestaurante();

        restaurante.prepararPedido(pedido);
        restaurante.cancelarPedido(pedido);

        String esperado = "Ana, Estado do pedido: Pedido cancelado ! (por Restaurante Pizza)";
        Assertions.assertEquals(esperado, cliente.getUltimaNotificacao());
        Assertions.assertSame(CanceladoEstado.getInstance(), pedido.getEstado());

        Assertions.assertFalse(restaurante.entregarPedido(pedido));
        Assertions.assertFalse(restaurante.sairPedido(pedido));
    }

    @Test
    void verificarComidaMontadaComDecorator_Hamburguer() {
        Cliente cliente = new Cliente("Lucas");
        Pedido pedido = cliente.fazerPedido("RestauranteHamburguer");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);

        RestauranteHamburguer rest = (RestauranteHamburguer) restaurante;
        Comida comida = rest.getUltimaComida();

        Assertions.assertEquals("Hambúrguer simples, Bacon, Queijo", comida.getDescricao());
        Assertions.assertEquals(14.0, comida.getPreco(), 0.01);
    }

    @Test
    void verificarComidaMontadaComDecorator_Pizza() {
        Cliente cliente = new Cliente("Maria");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);

        RestaurantePizza rest = (RestaurantePizza) restaurante;
        Comida comida = rest.getUltimaComida();

        Assertions.assertEquals("Pizza simples, Queijo", comida.getDescricao());
        Assertions.assertEquals(13.5, comida.getPreco(), 0.01);
    }


    @Test
    void fluxoCompletoComPagamentoPix() {
        Cliente cliente = new Cliente("Carlos");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        restaurante.sairPedido(pedido);
        restaurante.entregarPedido(pedido);

        Pagamento pagamentoOnline = new PagamentoOnline(55.0f);
        pagamentoOnline.setMetodo(new PagamentoPix());
        pedido.setPagamento(pagamentoOnline);

        String resultadoPagamento = pedido.realizarPagamento();

        Assertions.assertEquals(
                "Iniciando pagamento em loja online... Pagamento de R$55.0 realizado via PIX.",
                resultadoPagamento
        );
    }

    @Test
    void fluxoComPagamentoIndisponivelOnline_Dinheiro() {
        Cliente cliente = new Cliente("Bruna");
        Pedido pedido = cliente.fazerPedido("RestauranteHamburguer");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        restaurante.sairPedido(pedido);
        restaurante.entregarPedido(pedido);

        Pagamento pagamentoOnline = new PagamentoOnline(30.0f);
        pagamentoOnline.setMetodo(new PagamentoDinheiro());
        pedido.setPagamento(pagamentoOnline);

        String resultadoPagamento = pedido.realizarPagamento();

        Assertions.assertEquals("Método de pagamento não disponível online", resultadoPagamento);
    }

    @Test
    void fluxoPagamentoLojaFisicaComDebito() {
        Cliente cliente = new Cliente("Eduardo");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        restaurante.sairPedido(pedido);
        restaurante.entregarPedido(pedido);

        Pagamento pagamentoFisico = new PagamentoLojaFisica(40.0f);
        pagamentoFisico.setMetodo(new PagamentoCartaoDebito());
        pedido.setPagamento(pagamentoFisico);

        String resultadoPagamento = pedido.realizarPagamento();

        Assertions.assertEquals(
                "Iniciando pagamento em loja física... Pagamento de R$40.0 realizado com Cartão de Débito.",
                resultadoPagamento
        );
    }

    @Test
    void pagamentoNaoConfigurado() {
        Cliente cliente = new Cliente("Juliana");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        String resultadoPagamento = pedido.realizarPagamento();

        Assertions.assertEquals("Pagamento não configurado.", resultadoPagamento);
    }

    @Test
    void fluxoCompletoComEntregaExpress() {
        Cliente cliente = new Cliente("Lúcia");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        restaurante.sairPedido(pedido);
        restaurante.entregarPedido(pedido);

        pedido.setEntrega(new FabricaExpress());
        String resultadoEntrega = pedido.realizarEntrega();

        Assertions.assertEquals(
                "Entrega rápida com Moto. Entregador Express: Pronto para entrega rápida!",
                resultadoEntrega
        );
    }

    @Test
    void fluxoCompletoComEntregaPadrao() {
        Cliente cliente = new Cliente("Roberto");
        Pedido pedido = cliente.fazerPedido("RestauranteHamburguer");

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        restaurante.sairPedido(pedido);
        restaurante.entregarPedido(pedido);

        pedido.setEntrega(new FabricaPadrao());
        String resultadoEntrega = pedido.realizarEntrega();

        Assertions.assertEquals(
                "Entrega em grande quantidade com Carro. Entregador Padrão: Pronto para entrega regular.",
                resultadoEntrega
        );
    }

    @Test
    void entregaNaoConfigurada() {
        Cliente cliente = new Cliente("Fernanda");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        String resultadoEntrega = pedido.realizarEntrega();

        Assertions.assertEquals("Entrega não configurada.", resultadoEntrega);
    }

}
