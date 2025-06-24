package org.example;

public class PagamentoPix implements MetodoPagamento {

    @Override
    public String pagarPedido(double valor) {
        return "Pagamento de R$" + valor + " realizado via PIX.";
    }
}