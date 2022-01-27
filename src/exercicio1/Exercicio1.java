package exercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String dtNascimentoInput;
        boolean repetir = true;

        do {
            try {
                System.out.print("Digite sua data de nascimento (dia/mês/ano): ");
                dtNascimentoInput = sc.nextLine();

                DateTimeFormatter formatterDefault = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                DateTimeFormatter formatterModified = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate dtNascimento = LocalDate.parse(dtNascimentoInput, formatterModified);

                long idade = ChronoUnit.YEARS.between(dtNascimento, LocalDate.now());

                System.out.println("Você nasceu em " + dtNascimento.format(formatterModified) + " e tem " + idade + " anos!");

                if (idade >= 18) {
                    System.out.println("Você é maior de idade e pode acessar o sistema!");
                } else {
                    System.out.println("Você precisa ter 18 anos ou mais para acessar o sistema!");
                }

                repetir = false;
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Data Inválida!");
            } catch (DateTimeParseException dateTimeParseException) {
                System.err.println("Erro ao formatar data! Utilize o padrão dia, mês, ano. (dia/mês/ano)");
            }

        } while(repetir);


    }
}
