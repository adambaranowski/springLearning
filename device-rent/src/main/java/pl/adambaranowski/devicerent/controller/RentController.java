package pl.adambaranowski.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.devicerent.model.Customer;
import pl.adambaranowski.devicerent.model.Device;
import pl.adambaranowski.devicerent.properties.exceptions.RentException;
import pl.adambaranowski.devicerent.repository.CategoryRepository;
import pl.adambaranowski.devicerent.repository.CustomerRepository;
import pl.adambaranowski.devicerent.repository.DeviceRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private DeviceRepository deviceRepository;
    private Scanner scanner;

    @Autowired
    public RentController(CategoryRepository categoryRepository, CustomerRepository customerRepository, DeviceRepository deviceRepository, Scanner scanner) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.deviceRepository = deviceRepository;
        this.scanner = scanner;
    }

    @Transactional
    public void rentDeviceToCustomer(){
        try {
            rent();
        }catch (RentException e){
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj ID klienta:");
        long customerId = scanner.nextLong();
        System.out.println("Podaj ID urządzenia:");
        long deviceId = scanner.nextLong();


        Optional<Device> device = deviceRepository.findById(deviceId);
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isPresent()) {
            device.ifPresentOrElse(dev -> {
                if (dev.getQuantity() > dev.getCustomers().size())
                    dev.addCustomer(customer.get());
                else
                    throw new RentException("Brak wolnych urządzeń!");
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        } else
            throw new RentException("Brak klienta o wskazanym id");

    }
}
