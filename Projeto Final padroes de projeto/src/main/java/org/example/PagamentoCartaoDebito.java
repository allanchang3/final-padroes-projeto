    package org.example;

    public class PagamentoCartaoDebito implements MetodoPagamento {

        @Override
        public String pagarPedido(double valor) {
            return "Pagamento de R$" + valor + " realizado com Cartão de Débito.";
        }
    }