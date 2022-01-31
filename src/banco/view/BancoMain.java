package banco.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BancoMain {

    public static void main(String[] args) {

        System.out.println("BEM VINDO AO BANCO TECH DIVE!");
        iniciar();
        System.out.println("Obrigado por utilizar o Banco TechDive, até a próxima!");

    }

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            BancoMenu.exibeMenuInicial();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException numberFormatException) {
                System.err.println("Número inválido!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Opção Inválida!");
            }
            Menus.escolheOpcao(opcao);
        } while (opcao != 9);
    }
}
