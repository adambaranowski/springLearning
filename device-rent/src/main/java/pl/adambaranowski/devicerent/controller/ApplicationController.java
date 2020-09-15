package pl.adambaranowski.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.adambaranowski.devicerent.properties.exceptions.InvalidOptionException;
import pl.adambaranowski.devicerent.properties.options.Option;
import pl.adambaranowski.devicerent.repository.DeviceRepository;

import java.util.Arrays;
import java.util.Scanner;

import static pl.adambaranowski.devicerent.properties.options.Option.*;

@Controller
public class ApplicationController {

    private Scanner scanner;
    private DeviceController deviceController;
    private CustomerController customerController;
    private CategoryController categoryController;
    private RentController rentController;

    @Autowired
    public ApplicationController(Scanner scanner, DeviceController deviceController, CustomerController customerController, CategoryController categoryController, RentController rentController) {
        this.scanner = scanner;
        this.deviceController = deviceController;
        this.customerController = customerController;
        this.categoryController = categoryController;
        this.rentController = rentController;
    }




    public void mainLoop(){
        Option option;
        do{

            printOptions();
            option = readOption();
            executeOption(option);

        }while (option!= EXIT);
    }

    private Option readOption(){
        boolean correctOptionSelected = false;
        Option option = null;
        while (!correctOptionSelected){
            System.out.println("Podaj Id opji: ");
            int optionId = scanner.nextInt();
            try {
                option = Option.fromNumber(optionId);
                correctOptionSelected = true;
            }catch (InvalidOptionException e){
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(Option option){
        switch (option) {
            case ADD_DEVICE:
                deviceController.addDevice();
                break;
            case ADD_CATEGORY:
                categoryController.createCategory();
                break;
            case ADD_CUSTOMER:
                customerController.addCustomer();
                break;
            case RENT_DEVICE:
                rentController.rentDeviceToCustomer();
                break;
            case DELETE_DEVICE:
                deviceController.removeDevice();
                break;
            case DELETE_CATEGORY:
                categoryController.removeCategory();
                break;
            case DELETE_CUSTOMER:
                customerController.removeCustomer();
                break;
            case EXIT:
                closeApp();
        }
    }

    private void closeApp() {
        scanner.close();
        System.out.println("Bye bye!");
    }
    private void printOptions(){
        Arrays.stream(Option.values()).forEach(option -> System.out.println(option.toString()));
    }
}
