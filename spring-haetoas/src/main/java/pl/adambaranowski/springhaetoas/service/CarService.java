package pl.adambaranowski.springhaetoas.service;

import pl.adambaranowski.springhaetoas.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

List<Car> getAllCars();

Optional<Car> getCarById(Long id);

List<Car> getCarByColor(String color);
}
