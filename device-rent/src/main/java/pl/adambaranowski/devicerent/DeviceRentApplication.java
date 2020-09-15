package pl.adambaranowski.devicerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.adambaranowski.devicerent.controller.ApplicationController;
import pl.adambaranowski.devicerent.dao.DeviceDao;
import pl.adambaranowski.devicerent.model.Category;
import pl.adambaranowski.devicerent.model.Customer;
import pl.adambaranowski.devicerent.model.Device;
import pl.adambaranowski.devicerent.repository.DeviceRepository;

import java.util.Scanner;

@SpringBootApplication
public class DeviceRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DeviceRentApplication.class, args);

//        DeviceDao deviceDao = ctx.getBean(DeviceDao.class);
//
//
//        Device device1 = new Device("Kosa", "Kosa Spalinowa", 5, 1234.50);
//        Device device2 = new Device("Piła", "Piła Spalinowa", 3, 5834.50);
//
//        Category category1 = new Category("Do trawy", "kosiarki i kosy");
//        Category category2 = new Category("Do drewna", "Piły i tartaki");
//
//        Customer customer1 = new Customer("Adam", "Baranowski", "1234", "998745");
//        Customer customer2 = new Customer("Ania", "Czarna", "43243", "999657");
//
//        device1.addCategory(category1);
//        device2.addCategory(category2);
//        device1.addCustomer(customer1);
//        device2.addCustomer(customer2);
//
//        //deviceDao.create(device1);
//        //deviceDao.create(device2);
//
//        DeviceRepository deviceRepository = ctx.getBean(DeviceRepository.class);
//        deviceRepository.save(device1);


        ApplicationController controller = ctx.getBean(ApplicationController.class);
        controller.mainLoop();
    }

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

}
