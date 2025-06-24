package org.example;

public abstract class Pagamento {

    protected MetodoPagamento metodoPagamento;

    protected float valor;

    public Pagamento(float valor) {
        this.valor = valor;
    }

    public void setMetodo(MetodoPagamento metodoPagamento) {this.metodoPagamento = metodoPagamento;};

    public void setValor(float valor) {this.valor = valor;}

    public abstract String realizarPagamento();
}
