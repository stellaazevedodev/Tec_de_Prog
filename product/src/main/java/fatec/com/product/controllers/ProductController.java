// pacote que a classe cleinteController pertence
package fatec.com.product.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//use a classe Product para criar os objetos que serao retornados pela API
import fatec.com.product.models.Product;
import fatec.com.product.models.SpecialProduct;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController // responde via web
@RequestMapping("/products")
public class ProductController {

    // new é um operador que cria um novo objeto
    // varivel é o endereço de memoria onde o objeto esta armazenado
    // ArrayList é uma classe que implementa a interface List e permite armazenar
    // uma lista de objetos do tipo Product
    private ArrayList<Product> products = new ArrayList();

    // metodo construtor possui o mesmo nome que a classe
    // Começar a funcionar quando faz o new

    public ProductController() {
        // declara uma variavel do tipo Product
        // cria um objeto do tipo Product e atribui uma variavel
        Product p1 = new Product(1L, "Notebook", 3500.00,
                "Notebook Gamer com processador Intel Core i7, 16GB de RAM e placa de vídeo dedicada.");
        // manipula os atributos do objeto usando os metodos set

        Product p2 = new Product(2L, "Smartphone", 1500.00,
                "Smartphone com tela de 6.1 polegadas, 128GB de armazenamento e câmera de 48MP.");

        Product p3 = new Product(3L, "Fone de Ouvido", 200.00,
                "Fone de ouvido sem fio com cancelamento de ruído e bateria de longa duração.");

        SpecialProduct p4 = new SpecialProduct(4L, "Tablet", 1000.00,
                "Tablet com tela de 10 polegadas e processador rápido.", 0.10);

        // add objetos na lista de produtos
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

    }

    // aciona quando tiver um id na url
    // @PathVariable é uma anotação que indica que o valor do id será extraído da
    // URL, esse valor é guardado na variável id do tipo long
    @GetMapping("/{id}")
    public Product getProcutById(@PathVariable long id) {
        return products.stream() // olha item por item da lista de produtos
                .filter(p -> p.getId() == id)
                .findFirst() // Devolve o primeiro que encontrar
                .orElse(null);// se não encontrar nenhum produto com o id fornecido, retorna null
    }

    @GetMapping // Esta anotação diz ao Spring que este método responde ao GET /products
    public ArrayList<Product> getProducts() {
        return products;
    }

    @PostMapping // "quando o metodo post for acionado execute essa função"
    public Product createProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    //add caso o produto seja especial ou não, para isso é necessário verificar se o produto que esta chegando tem o campo desconto
    @PostMapping("/special")
    public SpecialProduct createSpecialProduct(
            @RequestBody SpecialProduct product) {

        products.add(product);

        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {

            if (product.getId().equals(id)) {

                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());

                // 1° condição verificar se o produto que esta na lista é do tipo SpecialProduct
                if (product instanceof SpecialProduct) {

                    // campo desconto
                    Double newDiscount =
                        ((SpecialProduct) updatedProduct).getDiscount(); //permite que o produto seja tratado como um SpecialProduct

                    ((SpecialProduct) product)
                            .setDiscount(newDiscount);
                    }

                return product;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        for (Product product : products) {

            if (product.getId().equals(id)) {

                products.remove(product);

                return "Produto removido com sucesso!";
            }
        }

        return "Produto não encontrado.";
    }
}
// obs.: p -> variável que guarda o obj; P-> classe/tipo