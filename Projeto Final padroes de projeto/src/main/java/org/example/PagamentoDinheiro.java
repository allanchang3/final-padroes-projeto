package org.example;

public class PagamentoDinheiro implements MetodoPagamento {

    @Override
    public String pagarPedido(double valor) {
        return "Pagamento de R$" + valor + " realizado no dinheiro.";
    }
}