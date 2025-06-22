package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteFluxoGeral {

    @Test
    void fluxoCompletoDoPedidoUtilizandoRestaurante() {
        Cliente cliente = new Cliente("João");
        Pedido pedido = cliente.fazerPedido("RestauranteItaliano");

        String esperada1 = "João, Estado do pedido: Pedido criado ! (por Restaurante Italiano)";
        Assertions.assertEquals(esperada1, cliente.getUltimaNotificacao());

        IRestaurante restaurante = pedido.getRestaurante();
        restaurante.prepararPedido(pedido);
        String esperada2 = "João, Estado do pedido: Pedido sendo preparado! (por Restaurante Italiano)";
        Assertions.assertEquals(esperada2, cliente.getUltimaNotificacao());
        Assertions.assertSame(PreparandoEstado.getInstance(), pedido.getEstado());

        restaurante.sairPedido(pedido);
        String esperada3 = "João, Estado do pedido: Pedido saiu para entrega! (por Restaurante Italiano)";
        Assertions.assertEquals(esperada3, cliente.getUltimaNotificacao());
        Assertions.assertSame(SaiuEstado.getInstance(), pedido.getEstado());

        restaurante.entregarPedido(pedido);
        String esperada4 = "João, Estado do pedido: Pedido entregue ! (por Restaurante Italiano)";
        Assertions.assertEquals(esperada4, cliente.getUltimaNotificacao());
        Assertions.assertSame(EntregueEstado.getInstance(), pedido.getEstado());

        boolean cancelamento = restaurante.cancelarPedido(pedido);
        Assertions.assertFalse(cancelamento);
        Assertions.assertSame(EntregueEstado.getInstance(), pedido.getEstado());
    }

    @Test
    void fluxoCanceladoDurantePreparacaoUtilizandoRestaurante() {
        Cliente cliente = new Cliente("Ana");
        Pedido pedido = cliente.fazerPedido("RestauranteJapones");

        IRestaurante restaurante = pedido.getRestaurante();

        restaurante.prepararPedido(pedido);
        restaurante.cancelarPedido(pedido);

        String esperado = "Ana, Estado do pedido: Pedido cancelado ! (por Restaurante Japonês)";
        Assertions.assertEquals(esperado, cliente.getUltimaNotificacao());
        Assertions.assertSame(CanceladoEstado.getInstance(), pedido.getEstado());

        Assertions.assertFalse(restaurante.entregarPedido(pedido));
        Assertions.assertFalse(restaurante.sairPedido(pedido));
    }
}
