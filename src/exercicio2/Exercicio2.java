package exercicio2;

import java.time.*;

public class Exercicio2 {

    public static void main(String[] args) {

        ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoNewYork = ZoneId.of("America/New_York");

        LocalDateTime saidaSemFuso = LocalDateTime.of(2022, Month.MARCH, 18, 22, 30);
        LocalDateTime chegadaSemFuso = LocalDateTime.of(2022, Month.MARCH, 19, 7, 10);

        ZonedDateTime saidaComFuso = ZonedDateTime.of(saidaSemFuso, fusoSaoPaulo);
        ZonedDateTime chegadaComFuso = ZonedDateTime.of(chegadaSemFuso, fusoNewYork);

        System.out.println("Sem fuso horário: ");
        System.out.println("Saída: "+saidaSemFuso);
        System.out.println("Chegada: "+chegadaSemFuso);

        Duration duracaoVooSemFuso = Duration.between(saidaSemFuso, chegadaSemFuso);
        System.out.print("Duração do voo sem fuso horário: ");
        System.out.println(duracaoVooSemFuso);

        String duracaoSemFusoFormatada = String.format("%02d:%02d:%02d",
                        duracaoVooSemFuso.toHours(),
                        duracaoVooSemFuso.toMinutesPart(),
                        duracaoVooSemFuso.toSecondsPart());
        System.out.println("Duração do voo sem fuso horário formatada: " + duracaoSemFusoFormatada);

        System.out.println("------------------------------------------------");

        System.out.println("Com fuso horário: ");
        System.out.println("Saída: " + saidaComFuso);
        System.out.println("Chegada: " + chegadaComFuso);

        Duration duracaoVooComFuso = Duration.between(saidaComFuso, chegadaComFuso);
        System.out.print("Duração do voo com fuso horário:");
        System.out.println(duracaoVooComFuso);

        String duracaoComFusoFormatada = String.format("%02d:%02d:%02d",
                duracaoVooComFuso.toHours(),
                duracaoVooComFuso.toMinutesPart(),
                duracaoVooComFuso.toSecondsPart());
        System.out.println("Duração do voo com fuso horário formatada: " + duracaoComFusoFormatada);

        System.out.println("------------------------------------------------");

        Instant instanteSaidaSemFuso = saidaSemFuso.toInstant(ZoneOffset.UTC);
        Instant instanteChegadaSemFuso = chegadaSemFuso.toInstant(ZoneOffset.UTC);

        Duration duracaoVooInstanteSemFuso = Duration.between(instanteSaidaSemFuso, instanteChegadaSemFuso);
        System.out.print("Duração do voo em instante sem fuso: ");
        System.out.println(duracaoVooInstanteSemFuso);

        String duracaoInstanteSemFusoFormatada = String.format("%02d:%02d:%02d",
                                                                duracaoVooInstanteSemFuso.toHoursPart(),
                                                                duracaoVooInstanteSemFuso.toMinutesPart(),
                                                                duracaoVooInstanteSemFuso.toSecondsPart());
        System.out.println("Duração do voo em instante sem fuso FORMATADA: "+duracaoInstanteSemFusoFormatada);

        System.out.println("------------------------------------------------");

        Instant instanteSaidaComFuso = Instant.from(saidaComFuso);
        Instant instanteChegadaComFuso = Instant.from(chegadaComFuso);

        Duration duracaoVooInstanteComFuso = Duration.between(instanteSaidaComFuso, instanteChegadaComFuso);
        System.out.print("Duração do voo em instante com fuso: ");
        System.out.println(duracaoVooInstanteComFuso);

        String duracaoInstanteComFusoFormatada = String.format("%02d:%02d:%02d",
                duracaoVooInstanteComFuso.toHoursPart(),
                duracaoVooInstanteComFuso.toMinutesPart(),
                duracaoVooInstanteComFuso.toSecondsPart());
        System.out.println("Duração do voo em instante com fuso FORMATADA: "+duracaoInstanteComFusoFormatada);
    }
}
