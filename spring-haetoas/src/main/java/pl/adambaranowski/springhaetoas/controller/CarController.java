package pl.adambaranowski.springhaetoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adambaranowski.springhaetoas.model.Car;
import pl.adambaranowski.springhaetoas.service.CarService;

import java.awt.*;
import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.awt.PageAttributes.MediaType.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/cars",
        produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<Car>> getCars(){
        List<Car> cars = carService.getAllCars();

        cars.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarId()).withSelfRel()));
        CollectionModel<Car> collectionModel = CollectionModel.of(cars);
        collectionModel.add(linkTo(CarController.class).withSelfRel());
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getCarById(@PathVariable Long id){
//        Optional<Car> carById = carService.getCarById(id);
//        return new ResponseEntity<>(carById.orElseThrow(NoSuchElementException::new), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Link link = linkTo(CarController.class).slash(id).withSelfRel();

        Optional<Car> carById = carService.getCarById(id);
        Car car = carById.orElseThrow(NoSuchElementException::new).add(link);


        return new ResponseEntity<>(car, HttpStatus.OK);
    }



    @GetMapping("/color/{color}")
    public ResponseEntity<CollectionModel<Car>> getCarsByColor(@PathVariable String color){
        List<Car> carByColor = carService.getCarByColor(color);

        carByColor.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarId()).withSelfRel()));
        carByColor.forEach(car -> car.add(linkTo(CarController.class).withRel("allColors")));

        CollectionModel<Car> collectionModel = CollectionModel.of(carByColor);
        collectionModel.add(linkTo(CarController.class).withSelfRel());

        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }


}
