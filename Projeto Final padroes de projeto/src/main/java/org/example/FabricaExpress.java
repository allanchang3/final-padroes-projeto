package org.example;

public class FabricaExpress implements FabricaAbstrata {
    @Override
    public Veiculo criarVeiculo() {
        return new MotoExpress();
    }

    @Override
    public Entregador criarEntregador() {
        return new EntregadorExpress();
    }
}