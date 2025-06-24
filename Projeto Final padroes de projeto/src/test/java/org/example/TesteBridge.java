package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteBridge {

    @Test
    public void deveRealizarPagamentoOnlineComPix() {
        MetodoPagamento metodoPagamento = new PagamentoPix();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(100f);
        pagamentoOnline.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja online... Pagamento de R$100.0 realizado via PIX.",
                pagamentoOnline.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoOnlineComDinheiro() {
        MetodoPagamento metodoPagamento = new PagamentoDinheiro();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(100f);
        pagamentoOnline.setMetodo(metodoPagamento);
        assertEquals("Método de pagamento não disponível online",
                pagamentoOnline.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoOnlineComCredito() {
        MetodoPagamento metodoPagamento = new PagamentoCartaoCredito();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(100f);
        pagamentoOnline.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja online... Pagamento de R$100.0 realizado com Cartão de Crédito.",
                pagamentoOnline.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoOnlineComDebito() {
        MetodoPagamento metodoPagamento = new PagamentoCartaoDebito();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(100f);
        pagamentoOnline.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja online... Pagamento de R$100.0 realizado com Cartão de Débito.",
                pagamentoOnline.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoLojaFisicaComPix() {
        MetodoPagamento metodoPagamento = new PagamentoPix();
        PagamentoLojaFisica pagamentoLojaFisica = new PagamentoLojaFisica(100f);
        pagamentoLojaFisica.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja física... Pagamento de R$100.0 realizado via PIX.",
                pagamentoLojaFisica.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoLojaFisicaComDinheiro() {
        MetodoPagamento metodoPagamento = new PagamentoDinheiro();
        PagamentoLojaFisica pagamentoLojaFisica = new PagamentoLojaFisica(100f);
        pagamentoLojaFisica.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja física... Pagamento de R$100.0 realizado no dinheiro.",
                pagamentoLojaFisica.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoLojaFisicaComCredito() {
        MetodoPagamento metodoPagamento = new PagamentoCartaoCredito();
        PagamentoLojaFisica pagamentoLojaFisica = new PagamentoLojaFisica(100f);
        pagamentoLojaFisica.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja física... Pagamento de R$100.0 realizado com Cartão de Crédito.",
                pagamentoLojaFisica.realizarPagamento());
    }

    @Test
    public void deveRealizarPagamentoLojaFisicaComDebito() {
        MetodoPagamento metodoPagamento = new PagamentoCartaoDebito();
        PagamentoLojaFisica pagamentoLojaFisica = new PagamentoLojaFisica(100f);
        pagamentoLojaFisica.setMetodo(metodoPagamento);
        assertEquals("Iniciando pagamento em loja física... Pagamento de R$100.0 realizado com Cartão de Débito.",
                pagamentoLojaFisica.realizarPagamento());
    }

}
