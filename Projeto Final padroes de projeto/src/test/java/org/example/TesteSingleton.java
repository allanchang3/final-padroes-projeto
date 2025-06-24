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
    public void deveRetornarMesmoObjetoSingleton() {
        EntregueEstado instancia1 = EntregueEstado.getInstance();
        EntregueEstado instancia2 = EntregueEstado.getInstance();
        assertSame(instancia1, instancia2);
    }
}
