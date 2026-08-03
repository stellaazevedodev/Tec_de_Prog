package com.fatec.employee.models;

public class Employee {
    
    //atributos
    private Long id;
    private String name;
    private Double salary;
    private String position;

    //metodo construtor 
    public Employee(Long id, String name, Double salary, String position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public Employee() {
    }


    //tornando publicos para poder manipular os atributos
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Double getSalary(){
        return salary;
    }
    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
}
