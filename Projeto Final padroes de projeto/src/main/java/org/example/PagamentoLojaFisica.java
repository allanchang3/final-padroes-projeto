package org.example;

public class PagamentoLojaFisica extends Pagamento {

    public PagamentoLojaFisica(float valor) {
        super(valor);
    }

    @Override
    public String realizarPagamento() {
       return "Iniciando pagamento em loja física... " + this.metodoPagamento.pagarPedido(this.valor);
    }
}
