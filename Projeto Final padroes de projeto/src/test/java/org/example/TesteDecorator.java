package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteDecorator {

    @Test
    void testeHamburguerComBaconEQueijo() {
        Comida comida = new Hamburguer();
        comida = new AdicionalBacon(comida);
        comida = new AdicionalQueijo(comida);

        Assertions.assertEquals("Hambúrguer simples, Bacon, Queijo", comida.getDescricao());
        Assertions.assertEquals(14.0, comida.getPreco(), 0.01);
    }

    @Test
    void testePizzaComQueijo() {
        Comida comida = new Pizza();
        comida = new AdicionalQueijo(comida);

        Assertions.assertEquals("Pizza simples, Queijo", comida.getDescricao());
        Assertions.assertEquals(13.5, comida.getPreco(), 0.01);
    }
}
