package banco.model;

import banco.controller.ClienteController;

public class Cliente {

    private String nome;
    private String cpf;
    private double renda;

    public Cliente(String nome, String cpf, double renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }
}
