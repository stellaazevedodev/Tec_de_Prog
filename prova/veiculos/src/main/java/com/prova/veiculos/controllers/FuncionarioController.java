package com.prova.veiculos.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.prova.veiculos.models.Funcionario;
import com.prova.veiculos.models.Motorista;
import com.prova.veiculos.models.Gerente;
import com.prova.veiculos.models.Veiculo;


@RestController
@RequestMapping("/")

public class FuncionarioController {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public FuncionarioController() {
        Funcionario f1 = new Funcionario(1L, "João");
        Funcionario f2 = new Funcionario(2L, "Maria");
        Funcionario f3 = new Funcionario(3L, "Pedro");

        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);

        // add funcionario motorista
        Motorista m4 = new Motorista(4L, "Carlos", "123456789");
        funcionarios.add(m4);

        // add funcionario gerente
        Funcionario g5 = new Gerente(5L, "Ana", "Vendas");
        funcionarios.add(g5);

        // add motorista ao veiculo
        Veiculo v1 = new Veiculo();
        v1.setPlaca("ABC-1234");
        v1.setModelo("Civic");

        m4.addVeiculo(v1);

        veiculos.add(v1);
    }

    // Pesquisa por ID motorista
    @PutMapping("/motoristas/{id}")
    public Funcionario updateFuncionario(
            @PathVariable Long id,
            @RequestBody Funcionario updatedFuncionario) {

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getId().equals(id)) {

                funcionario.setNome(updatedFuncionario.getNome());

                // verifica se é motorista
                if (funcionario instanceof Motorista) {

                    String novaCnh = ((Motorista) updatedFuncionario).getCnh();

                    ((Motorista) funcionario).setCnh(novaCnh);
                }

                // verifica se é gerente
                if (funcionario instanceof Gerente) {

                    String novoSetor = ((Gerente) updatedFuncionario).getSetor();

                    ((Gerente) funcionario)
                            .setSetor(novoSetor);
                }

                return funcionario;
            }
        }

        return null;
    }

    //FUNCIONARIOS

    //get funcionarios
    @GetMapping
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //post de funcionario
    @PostMapping 
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        funcionarios.add(funcionario);
        return funcionario;
    }

    //GERENTES

    //post de gerente
    @PostMapping("/gerente")
    public Gerente createGerente(
        @RequestBody Gerente gerente) {

            funcionarios.add(gerente);

        return gerente;
    }
    
    //get de gerentes
    @GetMapping("/gerentes")
    public ArrayList<Gerente> getGerentes() {

        ArrayList<Gerente> gerentes = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {

            if (funcionario instanceof Gerente) {

                gerentes.add((Gerente) funcionario);
            }
        }

        return gerentes;
    }

    //delete de gerentes
    @DeleteMapping("/gerentes/{id}")
    public Gerente deleteGerente(
            @PathVariable Long id) {

        for (Funcionario funcionario : funcionarios) {

            if (funcionario instanceof Gerente
                    && funcionario.getId().equals(id)) {

                funcionarios.remove(funcionario);

                return (Gerente) funcionario;
            }
        }

        return null;
    }

    //MOTORISTAS

    //post de motorista
    @PostMapping("/motorista")
    public Motorista createMotorista(
            @RequestBody Motorista motorista) {

        funcionarios.add(motorista);

        return motorista;
    }

    //get de motoristas
    @GetMapping("/motoristas")
    public ArrayList<Motorista> getMotoristas() {

        ArrayList<Motorista> motoristas = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {

            if (funcionario instanceof Motorista) {

                motoristas.add((Motorista) funcionario);
            }
        }

        return motoristas;
    }

    //VEICULOS

    //post de veiculo
    @PostMapping("/veiculos")
    public Veiculo createVeiculo(
        @RequestBody Veiculo veiculo) {

            veiculos.add(veiculo);

        return veiculo;
    }

    //get de veiculos
    @GetMapping("/veiculos")
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
}
