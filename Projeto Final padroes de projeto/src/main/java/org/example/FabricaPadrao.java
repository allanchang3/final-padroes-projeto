package org.example;

public class FabricaPadrao implements FabricaAbstrata {
    @Override
    public Veiculo criarVeiculo() {
        return new CarroPadrao();
    }

    @Override
    public Entregador criarEntregador() {
        return new EntregadorPadrao();
    }
}