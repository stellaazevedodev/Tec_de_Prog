package fatec.com.customer.controllers;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.com.customer.models.Customer;

@RestController 
@RequestMapping("/customers")

public class CustomerController {
    @GetMapping

    public ArrayList<Customer> getCustomers() {

        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("João Silva");
        c1.setEmail("joao.silva@example.com");
        c1.setPhone("(11) 1234-5678");
        c1.setAddress("Rua Exemplo, 123 - São Paulo/SP");
        c1.setCpf("123.456.789-00");

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setName("Maria Oliveira");
        c2.setEmail("maria.oliveira@example.com");
        c2.setPhone("(11) 9876-5432");
        c2.setAddress("Avenida Exemplo, 456 - São Paulo/SP");
        c2.setCpf("987.654.321-00");

        Customer c3 = new Customer();
        c3.setId(3L);
        c3.setName("Carlos Santos");
        c3.setEmail("carlos.santos@example.com");
        c3.setPhone("(11) 5678-1234");
        c3.setAddress("Travessa Exemplo, 789 - São Paulo/SP");
        c3.setCpf("456.789.123-00");

        Customer c4 = new Customer();
        c4.setId(4L);
        c4.setName("Ana Costa");
        c4.setEmail("ana.costa@example.com");
        c4.setPhone("(11) 4321-5678");
        c4.setAddress("Rua Exemplo, 101 - São Paulo/SP");
        c4.setCpf("321.654.987-00");

        Customer c5 = new Customer();
        c5.setId(5L);
        c5.setName("Pedro Almeida");
        c5.setEmail("pedro.almeida@example.com");
        c5.setPhone("(11) 8765-4321");
        c5.setAddress("Avenida Exemplo, 1000 - São Paulo/SP");
        c5.setCpf("654.321.987-00");

        ArrayList<Customer> Customers = new ArrayList<>();
        Customers.add(c1);
        Customers.add(c2);
        Customers.add(c3);
        Customers.add(c4);
        Customers.add(c5);

        return Customers;
    }

}
