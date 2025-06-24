package org.example;

public class Entrega {
    private Veiculo veiculo;
    private Entregador entregador;

    public Entrega(FabricaAbstrata fabrica) {
        this.veiculo = fabrica.criarVeiculo();
        this.entregador = fabrica.criarEntregador();
    }

    public String realizarEntrega() {
        return this.veiculo.entregar() + this.entregador.preparar();
    }

}