package com.fatec.employee.controllers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fatec.employee.models.Employee;
import com.fatec.employee.models.Manager;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController //visualizar via web e manipular os dados
@RequestMapping("/employees") //definir o caminho para acessar os dados
public class EmployeeController {

    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeController(){
        //primeiro objeto criado 
        Employee em1 = new Employee(1L, "Fernanda Hevilly", 10.500, "Engenheira de Software");

        Employee em2 = new Employee(2L, "Patricia Batista", 5.200, "Designer Junior");

        Employee em3 = new Employee(3L, "Thais Faria", 7.800, "Analista de Dados");

        Manager m1 = new Manager(4L, "Stella Azevedo", 15.000, "Gerente de Software", "TI");

        //add os objetos no arraylist
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        employees.add(m1);
    }

    //Metodo get 
    @GetMapping
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    //procurar um funcionario por id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employees.stream()
        .filter (e -> e.getId() == id)
        .findFirst()
        .orElse(null);
    }

    //metodo post 
    @PostMapping
    public Employee creatEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }


    //metodo put para atualizar um funcionario
    @PutMapping("/{id}")
    //PathVariable -> pega na url o numero do funcionario que deseja atualizar
    //RequestBody -> pega o corpo da requisicao com os dados atualizados do funcionario transforma de json para objeto employee
    //updateEmployee -> recebe o objeto atualizado e retorna o mesmo para confirmar a atualizacao
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmployee){
        for (Employee employee : employees){ //percorre cada objeto do Employee que esta no arraylist employees
            if(employee.getId().equals(id)){

                employee.setName(updateEmployee.getName());
                employee.setPosition(updateEmployee.getPosition());
                employee.setSalary(updateEmployee.getSalary());

                return employee;
            }
            
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                employees.remove(employee);
                return "Funcinário excluido com sucesso!";
            }
        }
        return "Produto não informado";
    }
}
