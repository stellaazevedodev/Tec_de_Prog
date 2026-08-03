package com.prova.veiculos.models;

public class Gerente extends Funcionario {
    
    private String setor;

    public String getSetor() {
        return setor;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Gerente() {

    }

    public Gerente(Long id, String nome, String setor) {
        super(id, nome);
        this.setor = setor;
    }
    
}
