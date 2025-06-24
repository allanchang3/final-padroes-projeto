package org.example;

public class PagamentoOnline extends Pagamento {

    public PagamentoOnline(float valor) {
        super(valor);
    }

    @Override
    public String realizarPagamento() {
        if(metodoPagamento instanceof PagamentoDinheiro)
        {
            return "Método de pagamento não disponível online";
        }
        else{
            return "Iniciando pagamento em loja online... " + this.metodoPagamento.pagarPedido(this.valor);
        }

    }
}
