package banco.view;

import banco.controller.ContaController;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BancoMenu {

    private static Scanner sc = new Scanner(System.in);
    private static int opcao = 0;

    public static void iniciar() {

        do {


            BancoMenu.exibeMenuInicial();
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException numberFormatException) {
                System.err.println("Número inválido!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Opção Inválida!");
            }
            Menus.escolheOpcao(opcao);
        } while (opcao != 9);
    }

    public static void exibeMenuInicial() {
        System.out.println("----------------------------------------");
        System.out.println("[ 1 ] - Cadastrar uma nova conta");
        System.out.println("[ 2 ] - Listar contas");
        System.out.println("[ 3 ] - Utilizar conta existente");
        System.out.println("[ 4 ] - Gerar Relatório");
        System.out.println("[ 9 ] - Sair do sistema");
        System.out.print("Digite o número correspondente à operação: ");

        try {
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    ContaController.criaConta();
                    break;
                case 2:
                    if (Conta.getContas().isEmpty()) {
                        System.out.println("Ainda não há contas cadastradas.");
                    } else {
                        for(Conta conta: Conta.getContas()) {
                            System.out.println(conta);
                        }
                    }
                    break;
                case 3:
                    menuConta(utilizaContaExistente());
                    break;
                case 4:
                    Menus.menuRelatorio();
                    break;
                case 9:
                    System.out.println("\nEncerrando sistema...");
                    break;
                default:
                    System.err.println("Opção Inválida!");
                    break;
            }

        } catch(NumberFormatException numberFormatException) {
            System.err.println("Número inválido!");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Opção Inválida!");
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao acessar banco de dados!");
        }
    }
}
