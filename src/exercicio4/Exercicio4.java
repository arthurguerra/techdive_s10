package exercicio4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean repetir = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("Insira uma data no formato dia, mês e ano");
            System.out.print("(dd/mm/aaaa): ");
            try {
                LocalDate data = LocalDate.parse(sc.nextLine(), formatter);
                boolean isSextaFeira13 = data.getDayOfWeek() == DayOfWeek.FRIDAY && data.getDayOfMonth() == 13;

                if (isSextaFeira13) {
                    System.out.println(data.format(formatter) + " é uma SEXTA FEIRA 13!");
                } else {
                    System.out.println(data.format(formatter) + " não é uma sexta feira 13!");
                }

                repetir = false;
            } catch (DateTimeParseException dateTimeParseException) {
                System.err.println("Data inválida!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Insira uma data válida!");
            }

        } while(repetir);
    }
}
