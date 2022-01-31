package exercicio5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int mes = 0, ano = 0;
        boolean repetir = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TemporalAdjuster ajustadorProximaSegundaFeira = TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY);
        List<LocalDate> segundasFeiras = new ArrayList<>();

        do {
            try {
                do {
                    System.out.print("Digite o mês (1 - 12): ");
                    mes = Integer.parseInt(sc.nextLine());
                } while (mes < 1 || mes > 12);
                do {
                    System.out.print("Digiite o ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                } while(ano < 0);

                repetir = false;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Número inválido!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Insira um número válido!");
            }
        } while (repetir);

        LocalDate inicio = LocalDate.of(ano, mes, 1);
        LocalDate fim    = inicio.plusMonths(1);

        while (inicio.isBefore(fim)) {
            inicio = inicio.with(ajustadorProximaSegundaFeira);
            segundasFeiras.add(inicio);
            inicio = inicio.plusWeeks(1);
        }

        System.out.printf("%nSegundas-Feiras do mês %d de %d.%n", mes, ano);
        segundasFeiras.stream().map(segunda -> segunda.format(formatter)).forEach(System.out::println);

    }
}
