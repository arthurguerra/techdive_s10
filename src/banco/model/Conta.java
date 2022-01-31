package banco.model;

import banco.model.enums.TipoTransacao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Conta {

    private Cliente cliente;
    private int idConta;
    private int agencia;
    private double saldo;
    private static int totalContas;
    private static ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Transacao> extrato = new ArrayList<>();


    public Conta(Cliente cliente, int agencia, double saldo, int idConta) throws FileNotFoundException {
        this.cliente = cliente;
        this.agencia = agencia;
        this.saldo = saldo;
        this.idConta = idConta;
//        Transacao.getTransacoes().add(new Transacao(TipoTransacao.CRIAR_CONTA, null, null, 0));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getIdConta() {
        return idConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public static ArrayList<Conta> getContas() {
        return contas;
    }

    public static int novaIdConta() {
        return totalContas++;
    }

    public boolean sacar(double valorSaque) {
        if (valorSaque <= this.saldo) {
            this.saldo -= valorSaque;
            Transacao transacao = new Transacao(TipoTransacao.SAQUE, this, null, valorSaque);
            extrato.add(transacao);
            Transacao.getTransacoes().add(transacao);
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        Transacao transacao = new Transacao(TipoTransacao.DEPOSITO, null, this, valorDeposito);
        extrato.add(transacao);
        Transacao.getTransacoes().add(transacao);
    }

    public boolean transferir(Conta contaDestino, double valorTransferencia) {
        if (valorTransferencia <= this.saldo) {
            this.saldo -= valorTransferencia;
            contaDestino.saldo += valorTransferencia;
            Transacao transacao = new Transacao(TipoTransacao.TRANSFERENCIA,this, contaDestino, valorTransferencia);
            extrato.add(transacao);
            contaDestino.extrato.add(transacao);
            Transacao.getTransacoes().add(transacao);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente para efetuar a transferência!");
            return false;
        }
    }
}
