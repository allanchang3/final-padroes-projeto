package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TesteObserver {

    @Test
    void deveNotificarClienteAoCriarPedido() {
        Cliente cliente = new Cliente("João");
        Pedido pedido = cliente.fazerPedido("RestauranteHamburguer");

        String esperado = "João, Estado do pedido: Pedido criado ! (por Restaurante Hamburguer)";
        assertEquals(esperado, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteQuandoPedidoMudaDeEstado() {
        Cliente cliente = new Cliente("Maria");
        Pedido pedido = cliente.fazerPedido("RestaurantePizza");

        pedido.setEstado(PreparandoEstado.getInstance());
        String esperado1 = "Maria, Estado do pedido: Pedido sendo preparado! (por Restaurante Pizza)";
        assertEquals(esperado1, cliente.getUltimaNotificacao());

        pedido.setEstado(SaiuEstado.getInstance());
        String esperado2 = "Maria, Estado do pedido: Pedido saiu para entrega! (por Restaurante Pizza)";
        assertEquals(esperado2, cliente.getUltimaNotificacao());

        pedido.setEstado(EntregueEstado.getInstance());
        String esperado3 = "Maria, Estado do pedido: Pedido entregue ! (por Restaurante Pizza)";
        assertEquals(esperado3, cliente.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteNaoInscrito() {
        Cliente cliente = new Cliente("Carlos");

        IRestaurante restaurante = RestauranteFactory.obterServico("RestaurantePizza");
        Pedido pedido = new Pedido(restaurante);
        pedido.setEstado(CriadoEstado.getInstance());

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasClienteInscritoNoPedidoCorreto() {
        Cliente cliente1 = new Cliente("Bruna");
        Cliente cliente2 = new Cliente("Lucas");

        Pedido pedido1 = cliente1.fazerPedido("RestaurantePizza");
        Pedido pedido2 = cliente2.fazerPedido("RestauranteHamburguer");

        pedido1.setEstado(PreparandoEstado.getInstance());
        assertEquals("Bruna, Estado do pedido: Pedido sendo preparado! (por Restaurante Pizza)", cliente1.getUltimaNotificacao());
        assertEquals("Lucas, Estado do pedido: Pedido criado ! (por Restaurante Hamburguer)", cliente2.getUltimaNotificacao());

        pedido2.setEstado(CanceladoEstado.getInstance());
        assertEquals("Lucas, Estado do pedido: Pedido cancelado ! (por Restaurante Hamburguer)", cliente2.getUltimaNotificacao());

        assertEquals("Bruna, Estado do pedido: Pedido sendo preparado! (por Restaurante Pizza)", cliente1.getUltimaNotificacao());
    }
}
