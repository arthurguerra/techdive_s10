package banco.controller;

import banco.model.Cliente;

public class ClienteController {

    public static boolean validaNomeTresCaracteres(String nome) {
        return nome.trim().length() > 3;
    }
}
