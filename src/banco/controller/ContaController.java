package banco.controller;

import banco.controller.utils.Cpf;
import banco.model.Cliente;
import banco.model.Conta;
import banco.model.Transacao;
import banco.model.enums.AgenciaEnum;
import banco.model.enums.TipoTransacao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class ContaController {

    private static Scanner sc = new Scanner(System.in);

    public static Conta criaConta() throws FileNotFoundException {

        String nome,cpf;
        double renda, saldo;
        int idAgencia;

        do {
            System.out.print("Digite o seu nome: ");
            nome = sc.nextLine();
        } while (!ClienteController.validaNomeTresCaracteres(nome));

        do {
            System.out.print("Digite o seu CPF (apenas números): ");
            cpf = sc.nextLine();
            if (!Cpf.validaCpf(cpf)) {
                System.out.println("CPF inválido!");
            }
        } while (!Cpf.validaCpf(cpf));

        System.out.print("Digite a sua renda mensal: ");
        renda = Double.parseDouble(sc.nextLine().trim().replace(".", ","));

        do {
            System.out.println("[ 1 ] Florianópolis\n[ 2 ] São Jose\n[ 3 ] Palhoça ");
            System.out.print("Digite a sua agência: ");
            idAgencia = Integer.parseInt(sc.nextLine());
        } while (idAgencia != 1 && idAgencia!= 2 && idAgencia != 3);

        System.out.print("Digite o seu saldo inicial: R$");
        saldo = Double.parseDouble(sc.nextLine().trim().replace("." , ","));

        Cliente cliente = new Cliente(nome, cpf, renda);
        Conta conta = new Conta(cliente, idAgencia, saldo, Conta.novaIdConta());

        Conta.getContas().add(conta);
        Transacao.adicionaTransacao(new Transacao(TipoTransacao.CRIAR_CONTA, null, null, 0));

        return conta;
    }

    public static void gravaContaNoBanco(Conta conta) throws FileNotFoundException {
        String contaFormatada = String.format("%s,%s,%s,%.2f"
                                    ,conta.getIdConta(), conta.getAgencia(), conta.getCliente().getNome(), conta.getSaldo());
        try (PrintStream ps = new PrintStream(new FileOutputStream("contas.csv", true))) {
            ps.println(contaFormatada);
        }
    }

    public static void carregaContasDoBanco() throws IOException {
        sc = new Scanner(new File("contas.csv"), StandardCharsets.UTF_8);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            try (Scanner linhaScanner = new Scanner(linha)) {
                linhaScanner.useLocale(Locale.US);
                linhaScanner.useDelimiter(",");
                int numConta = linhaScanner.nextInt();
                int numAgencia = linhaScanner.nextInt();
                String titular = linhaScanner.next();
                double saldo = linhaScanner.nextDouble();
                Conta conta = new Conta()
            }
        }
    }
}
