package org.example;

public class RestauranteFactory {

    public RestauranteFactory() {
    }

    public static IRestaurante obterServico(String servico) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example." + servico);
            objeto = classe.newInstance();
        } catch (Exception var4) {
            throw new IllegalArgumentException("Restaurante inexistente");
        }

        if (!(objeto instanceof IRestaurante)) {
            throw new IllegalArgumentException("Restaurante inválido");
        } else {
            return (IRestaurante) objeto;
        }
    }
}
