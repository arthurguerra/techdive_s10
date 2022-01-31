package exercicio3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {

        LocalDate inicio                        = LocalDate.of(Year.now().getValue(), 1, 1);
        LocalDate fim                           = LocalDate.of(Year.now().getValue(), 12, 31);
        List<LocalDate> primeirosSabadosDoMes   = new ArrayList<>();
        DateTimeFormatter formatter             = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TemporalAdjuster ajustadorProximoSabado = TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY);

        for (LocalDate dia = inicio; dia.isBefore(fim); dia = dia.plusMonths(1)) {
            primeirosSabadosDoMes.add(dia.with(ajustadorProximoSabado));
        }

        primeirosSabadosDoMes.stream().map(s -> s.format(formatter)).forEach(System.out::println);
    }
}
