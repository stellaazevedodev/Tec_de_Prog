package fatec.com.product.models;

import java.util.ArrayList;

// categoria de produtos
// REGRA DE NEGOCIO: um produto pode ter 1 categoria mas uma categoria pode ter varios produtos
public class Category {
    private Long id;
    private String name;
    private ArrayList<Product> products = new ArrayList<>();

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
    public ArrayList<Product> getProducts(){
        return products;
    }
    public void addProducts(Product product){
        this.products.add(product);
    }
}
