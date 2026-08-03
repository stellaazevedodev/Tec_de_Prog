package com.prova.veiculos.models;

public class Funcionario {
    private Long id;
    private String nome;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //construtor vazio
    public Funcionario() {

    }

    //construtor com parâmetros
    public Funcionario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
