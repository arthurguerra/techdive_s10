package exercicio6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercicio6 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("teste_saida4.txt");
        long byteSize = Files.size(path);
        long kbSize   = byteSize / 1024;
        long mbSize   = kbSize / 1024;

        System.out.println("Tamanho do arquivo em bytes: "+byteSize);
        System.out.println("Tamanho do arquivo em kilobytes: "+kbSize);
        System.out.println("Tamanho do arquivo em megabytes: "+mbSize);
    }
}
