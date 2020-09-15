package pl.adambaranowski.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.devicerent.model.Category;
import pl.adambaranowski.devicerent.model.Device;
import pl.adambaranowski.devicerent.properties.exceptions.CategoryNotFoundException;
import pl.adambaranowski.devicerent.properties.exceptions.DeviceNotFoundException;
import pl.adambaranowski.devicerent.repository.CategoryRepository;
import pl.adambaranowski.devicerent.repository.DeviceRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceController {
    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceController(Scanner scanner, DeviceRepository deviceRepository, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }


    private Device readDevice() {
        Device device = new Device();
        System.out.println("Nazwa urzadzenia:");
        device.setName(scanner.nextLine());
        System.out.println("Opis urządzenia");
        device.setDescription(scanner.nextLine());
        System.out.println("Cena urządzenia:");
        device.setPrice(scanner.nextDouble());
        System.out.println("Ilość(szt) urządzenia:");
        device.setQuantity(scanner.nextInt());
        System.out.println("Kategoria(id) urządzenia:");

        long id = scanner.nextLong();

        Optional<Category> category = categoryRepository.findById(id);
        scanner.nextLine();
        category.ifPresentOrElse(device::setCategory, () -> {
            throw new CategoryNotFoundException();
        });

        return device;
    }

    public void addDevice(){
        Device device = readDevice();
        deviceRepository.save(device);
    }

    public void removeDevice(){
        System.out.println("Podaj id urządzenia do usunięcia");
        long id = scanner.nextLong();
        Optional<Device> deviceToRemove = deviceRepository.findById(id);
        deviceToRemove.ifPresentOrElse(deviceRepository::delete, () -> {throw new DeviceNotFoundException();
        });
    }
}
