package pl.adambaranowski.mocktesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Api {
    private AnimalController animalController;

    @Autowired
    public Api(AnimalController animalController) {
        this.animalController = animalController;
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals(){
        return animalController.getAnimals();
    }

    @PostMapping("/animals")
    public void addAnimals(@RequestBody Animal animal){
        animalController.addAnimal(animal);
    }

//    @GetMapping("/message")
//    public ResponseEntity<Message> isCorrect(){
//
//        ResponseEntity<Message> result = ResponseEntity.of(Optional.of(new Message(true)));
//        return result;
//    }

    @GetMapping("/response")
    public ResponseEntity<String> response(){
//        Message message = new Message();
//        message.setCorrect(true);
//        return message;
        return new ResponseEntity<String>("{correct: true}", HttpStatus.OK);
    }

@GetMapping("/message")
public Message isCorrect(){
//        Message message = new Message();
//        message.setCorrect(true);
//        return message;
    return new Message(true);
}
}
