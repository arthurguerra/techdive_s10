package exercicio7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercicio7 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("teste_saida5.txt");
        System.out.println(contadorDeCaracteres(path, 'e'));
        System.out.println(Charset.defaultCharset().displayName());

    }

    public static long contadorDeCaracteres(Path path, char caracter) throws IOException {
        String textoCompleto = String.join("", Files.readAllLines(path)).toLowerCase();
        return textoCompleto.chars().filter(c -> c == caracter).count();
    }
}
