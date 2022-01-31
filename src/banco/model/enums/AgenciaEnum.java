package banco.model.enums;

public enum AgenciaEnum implements StringValueEnum {

    FPOLIS(1, "Florianópolis"),
    SAO_JOSE(2, "São José"),
    PALHOCA(3, "Palhoça");

    private int idAgencia;
    private String descricaoAgencia;

    AgenciaEnum(int idAgencia, String descricaoAgencia) {
        this.idAgencia = idAgencia;
        this.descricaoAgencia = descricaoAgencia;
    }

    @Override
    public int getValue() {
        return idAgencia;
    }

    @Override
    public String getDisplayName() {
        return descricaoAgencia;
    }
}
