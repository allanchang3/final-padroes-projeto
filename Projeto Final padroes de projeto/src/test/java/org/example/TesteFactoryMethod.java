package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesteFactoryMethod {

    @Test
    void deveRetornarExcecaoParaRestauranteInexistente() {
        try {
            IRestaurante servico = RestauranteFactory.obterServico("RestauranteMexicano");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Restaurante inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaRestauranteInvalido() {
        try {
            IRestaurante servico = RestauranteFactory.obterServico("Pizza");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Restaurante inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeDoRestauranteHamburguer() {
        IRestaurante restaurante = RestauranteFactory.obterServico("RestauranteHamburguer");
        assertEquals("Restaurante Hamburguer", restaurante.getNome());
    }
    @Test

    void deveRetornarNomeDoRestaurantePizza() {
        IRestaurante restaurante = RestauranteFactory.obterServico("RestaurantePizza");
        assertEquals("Restaurante Pizza", restaurante.getNome());
    }
}
