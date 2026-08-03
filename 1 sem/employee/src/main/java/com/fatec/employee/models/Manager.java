package com.fatec.employee.models;

public class Manager extends Employee{
    //atributo diferencial do manager(gerente)
    private String area;

    //construtor completo
    public Manager (Long id, String name, Double salary, String position, String area){
        super(id, name, salary, position);
        this.area = area;
    }

    //construtor vazio
    public Manager(){
        super();    
    }
    
    public String getArea(){
        return area;
    }

    public void setArea(String area){
        this.area = area;
    }
    
}
