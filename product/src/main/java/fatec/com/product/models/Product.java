package fatec.com.product.models;

public class Product {

    //metodo construtor possui o mesmo nome que a classe 
    public Product(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    // atributos
    private Long id; //long é um tipo de dado para armazenar números inteiros grandes
    private String name; //string é um tipo de dado para armazenar texto
    private Double price; //Double é um tipo de dado para armazenar números decimais
    private String description;

    // expor as em metodos publicos , ja que estavam privados
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
