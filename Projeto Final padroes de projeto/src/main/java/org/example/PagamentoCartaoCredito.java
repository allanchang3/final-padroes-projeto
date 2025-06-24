package org.example;

public class PagamentoCartaoCredito implements MetodoPagamento {

    @Override
    public String pagarPedido(double valor) {
        return "Pagamento de R$" + valor + " realizado com Cartão de Crédito.";
    }
}
