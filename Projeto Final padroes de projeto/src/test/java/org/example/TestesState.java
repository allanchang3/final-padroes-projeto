package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestesState {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido(new RestauranteItaliano());
    }

    @Test
    void estadoCriado_criar() {
        pedido.setEstado(CriadoEstado.getInstance());
        Assertions.assertFalse(pedido.criar(pedido));
    }

    @Test
    void estadoCriado_preparar() {
        pedido.setEstado(CriadoEstado.getInstance());
        Assertions.assertTrue(pedido.preparar(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof PreparandoEstado);
    }

    @Test
    void estadoCriado_sair() {
        pedido.setEstado(CriadoEstado.getInstance());
        Assertions.assertFalse(pedido.sair(pedido));
    }

    @Test
    void estadoCriado_entregar() {
        pedido.setEstado(CriadoEstado.getInstance());
        Assertions.assertFalse(pedido.entregar(pedido));
    }

    @Test
    void estadoCriado_cancelar() {
        pedido.setEstado(CriadoEstado.getInstance());
        Assertions.assertTrue(pedido.cancelar(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof CanceladoEstado);
    }

    @Test
    void estadoPreparando_criar() {
        pedido.setEstado(PreparandoEstado.getInstance());
        Assertions.assertFalse(pedido.criar(pedido));
    }

    @Test
    void estadoPreparando_preparar() {
        pedido.setEstado(PreparandoEstado.getInstance());
        Assertions.assertFalse(pedido.preparar(pedido));
    }

    @Test
    void estadoPreparando_sair() {
        pedido.setEstado(PreparandoEstado.getInstance());
        Assertions.assertTrue(pedido.sair(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof SaiuEstado);
    }

    @Test
    void estadoPreparando_entregar() {
        pedido.setEstado(PreparandoEstado.getInstance());
        Assertions.assertFalse(pedido.entregar(pedido));
    }

    @Test
    void estadoPreparando_cancelar() {
        pedido.setEstado(PreparandoEstado.getInstance());
        Assertions.assertTrue(pedido.cancelar(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof CanceladoEstado);
    }

    @Test
    void estadoSaiu_criar() {
        pedido.setEstado(SaiuEstado.getInstance());
        Assertions.assertFalse(pedido.criar(pedido));
    }

    @Test
    void estadoSaiu_preparar() {
        pedido.setEstado(SaiuEstado.getInstance());
        Assertions.assertFalse(pedido.preparar(pedido));
    }

    @Test
    void estadoSaiu_sair() {
        pedido.setEstado(SaiuEstado.getInstance());
        Assertions.assertFalse(pedido.sair(pedido));
    }

    @Test
    void estadoSaiu_entregar() {
        pedido.setEstado(SaiuEstado.getInstance());
        Assertions.assertTrue(pedido.entregar(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof EntregueEstado);
    }

    @Test
    void estadoSaiu_cancelar() {
        pedido.setEstado(SaiuEstado.getInstance());
        Assertions.assertTrue(pedido.cancelar(pedido));
        Assertions.assertTrue(pedido.getEstado() instanceof CanceladoEstado);
    }

    @Test
    void estadoEntregue_criar() {
        pedido.setEstado(EntregueEstado.getInstance());
        Assertions.assertFalse(pedido.criar(pedido));
    }

    @Test
    void estadoEntregue_preparar() {
        pedido.setEstado(EntregueEstado.getInstance());
        Assertions.assertFalse(pedido.preparar(pedido));
    }

    @Test
    void estadoEntregue_sair() {
        pedido.setEstado(EntregueEstado.getInstance());
        Assertions.assertFalse(pedido.sair(pedido));
    }

    @Test
    void estadoEntregue_entregar() {
        pedido.setEstado(EntregueEstado.getInstance());
        Assertions.assertFalse(pedido.entregar(pedido));
    }

    @Test
    void estadoEntregue_cancelar() {
        pedido.setEstado(EntregueEstado.getInstance());
        Assertions.assertFalse(pedido.cancelar(pedido));
    }

    @Test
    void estadoCancelado_criar() {
        pedido.setEstado(CanceladoEstado.getInstance());
        Assertions.assertFalse(pedido.criar(pedido));
    }

    @Test
    void estadoCancelado_preparar() {
        pedido.setEstado(CanceladoEstado.getInstance());
        Assertions.assertFalse(pedido.preparar(pedido));
    }

    @Test
    void estadoCancelado_sair() {
        pedido.setEstado(CanceladoEstado.getInstance());
        Assertions.assertFalse(pedido.sair(pedido));
    }

    @Test
    void estadoCancelado_entregar() {
        pedido.setEstado(CanceladoEstado.getInstance());
        Assertions.assertFalse(pedido.entregar(pedido));
    }

    @Test
    void estadoCancelado_cancelar() {
        pedido.setEstado(CanceladoEstado.getInstance());
        Assertions.assertFalse(pedido.cancelar(pedido));
    }
}
