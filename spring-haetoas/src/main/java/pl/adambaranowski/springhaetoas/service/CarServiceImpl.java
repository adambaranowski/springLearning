package pl.adambaranowski.springhaetoas.service;

import org.springframework.stereotype.Service;
import pl.adambaranowski.springhaetoas.model.Car;
import pl.adambaranowski.springhaetoas.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>(
                Arrays.asList(
                        new Car(1L, "Mercedes" , "GLC", Color.RED),
                        new Car(2L, "Opel" , "Astra", Color.BLUE),
                        new Car(3L, "Mazda" , "S6", Color.RED),
                        new Car(4L, "BMW" , "X4", Color.BLUE)
                )
        );
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getCarId()==id)
                .findFirst();
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return cars.stream()
                .filter(car -> car.getColor().getName().equals(color))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Car getCarrByColor(String color) {
        return cars.stream()
                .filter(car -> car.getColor().getName().equals(color))
                .findAny().get();
    }

    public static void main(String[] args) {
        CarServiceImpl carService = new CarServiceImpl();
        Color color = Color.BLUE;
        System.out.println(color.getName());
        System.out.println(carService.getCarByColor("red"));
    }
}
