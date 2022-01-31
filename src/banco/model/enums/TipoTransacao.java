package banco.model.enums;

public enum TipoTransacao implements StringValueEnum{
    SAQUE(1, "Saque"),
    DEPOSITO(2, "Depósito"),
    TRANSFERENCIA(3, "Transferência"),
    CRIAR_CONTA(4, "Nova Conta"),
    EXCLUIR_CONTA(5, "Excluir Conta");

    private int idTransacao;
    private String descricaoTransacao;

    TipoTransacao(int idTransacao, String descricaoTransacao) {
        this.idTransacao = idTransacao;
        this.descricaoTransacao = descricaoTransacao;
    }

    @Override
    public int getValue() {
        return idTransacao;
    }

    @Override
    public String getDisplayName() {
        return descricaoTransacao;
    }
}
