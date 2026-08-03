package com.prova.veiculos.models;

import java.util.ArrayList;

public class Motorista extends Funcionario {

    private String cnh;

    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Motorista() {
    }

    public Motorista(Long id, String nome, String cnh) {
        super(id, nome);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);

        // associa o motorista ao veículo
        veiculo.setMotorista(this);
    }
}