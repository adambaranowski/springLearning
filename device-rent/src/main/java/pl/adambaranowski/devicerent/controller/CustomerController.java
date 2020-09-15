package pl.adambaranowski.devicerent.controller;

import org.springframework.stereotype.Service;
import pl.adambaranowski.devicerent.model.Customer;
import pl.adambaranowski.devicerent.repository.CustomerRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerController {

    private Scanner scanner;
    private CustomerRepository customerRepository;

    public CustomerController(Scanner scanner, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
    }

    public void addCustomer(){
        Customer customer = readCustomer();
        customerRepository.save(customer);
        System.out.println("Dodano klienta");
        System.out.println(customer);
    }

    public void removeCustomer(){
        System.out.println("Podaj id usuwanego użytkownika: ");
        long id = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresentOrElse(customer1 -> customerRepository.delete(customer1), () -> System.out.println("nie ma takiego użytkownika"));

    }

    private Customer readCustomer(){
        Customer customer = new Customer();
        System.out.println("Podaj imię: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Podaj nazwisko: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Podaj pesel: ");
        customer.setPesel(scanner.nextLine());
        System.out.println("Podaj numer dowodu: ");
        customer.setId(scanner.nextLong());
        return customer;
    }


}
