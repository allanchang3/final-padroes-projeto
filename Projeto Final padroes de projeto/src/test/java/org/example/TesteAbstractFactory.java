package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TesteAbstractFactory {

    @Test
    void deveRealizarEntregaExpress() {
        FabricaAbstrata fabrica = new FabricaExpress();
        Entrega entrega = new Entrega(fabrica);
        assertEquals("Entrega rápida com Moto. Entregador Express: Pronto para entrega rápida!", entrega.realizarEntrega());
    }

    @Test
    void deveRealizarEntregaPadrao() {
        FabricaAbstrata fabrica = new FabricaPadrao();
        Entrega entrega = new Entrega(fabrica);
        assertEquals("Entrega em grande quantidade com Carro. Entregador Padrão: Pronto para entrega regular.", entrega.realizarEntrega());
    }
}
