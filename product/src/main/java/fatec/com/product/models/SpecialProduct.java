package fatec.com.product.models;



public class SpecialProduct extends Product {

    private Double discount;


    public SpecialProduct(Long id,
                          String name,
                          Double price,
                          String description,
                          Double discount) {
                            
        // esta dizendo que esses campos serão construidos usando o construtor da classe pai (Product)
        super(id, name, price, description);

        this.discount = discount;
    }


    //metodo construtor 
    public SpecialProduct() {
        super();
    }


    public Double getDiscount() {
        return discount;
    }


    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}