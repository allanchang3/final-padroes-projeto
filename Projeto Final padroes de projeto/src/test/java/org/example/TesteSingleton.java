package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class TesteSingleton {
    @Test
    public void deveRetornarMensagemEstadoEntregue() {
        assertEquals("Pedido entregue !", EntregueEstado.getInstance().getEstado());
    }

    @Test
    public void deveRetornarMensagemEstadoSaiu() {
        assertEquals("Pedido saiu para entrega!", SaiuEstado.getInstance().getEstado());
    }

    @Test
    public void deveRetornarMensagemEstadoPreparando() {
        assertEquals("Pedido sendo preparado!", PreparandoEstado.getInstance().getEstado());
    }

    @Test
    public void deveRetornarMensagemEstadoCriado() {
        assertEquals("Pedido criado !", CriadoEstado.getInstance().getEstado());
    }

    @Test
    public void deveRetornarMensagemEstadoCancelado() {
        assertEquals("Pedido cancelado !", CanceladoEstado.getInstance().getEstado());
    }

}
