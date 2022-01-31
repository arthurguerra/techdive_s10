package banco.model;

import banco.model.enums.TipoTransacao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class Transacao {

    private final TipoTransacao tipo;
    private final Conta contaOrigem;
    private final Conta contaDestino;
    private final double valor;
    private final String data;

    private static ArrayList<Transacao> transacoes = new ArrayList<>();

    public Transacao(TipoTransacao tipo, Conta contaOrigem, Conta contaDestino, double valor) {
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.data = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss")
                .format(LocalDateTime.now());
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public static ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    public static void adicionaTransacao(Transacao transacao) throws FileNotFoundException {
        getTransacoes().add(transacao);
        try (PrintStream ps = new PrintStream(new FileOutputStream("transacoes.csv", true))) {
            ps.println(transacao.formataTransacao());
        }
    }

    private String formataTransacao() {
        String transacaoFormatada;
        switch (this.getTipo().getValue()) {
            case 1:
                transacaoFormatada = String.format("%s,%s,%s,%.2f,%s"
                                                    ,tipo.getDisplayName(), contaOrigem.getIdConta(), "sem destinatário", valor, data);
                break;
            case 2:
                transacaoFormatada = String.format("%s,%s,%s,%.2f,%s"
                        ,tipo.getDisplayName(), "sem conta de origem", contaDestino.getIdConta(), valor, data);
                break;
            case 3:
                transacaoFormatada = String.format("%s,%s,%s,%.2f,%s"
                        ,tipo.getDisplayName(), contaOrigem.getIdConta(), contaDestino.getIdConta(), valor, data);
                break;
            case 4:
            case 5:
                transacaoFormatada = String.format("%s,%s,%s,%s,%s"
                        ,tipo.getDisplayName(), "-", "-", "-", data);
                break;
            default:
                return null;
        }
        return transacaoFormatada;
    }

    public static Optional<ArrayList<Transacao>> carregaTransacoesDoBanco() {
            
    }
}
