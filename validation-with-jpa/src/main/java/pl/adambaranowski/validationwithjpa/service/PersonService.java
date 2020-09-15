package pl.adambaranowski.validationwithjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.validationwithjpa.model.Person;
import pl.adambaranowski.validationwithjpa.repository.PersonRepository;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //obsługujemy wyjątek w wyższej hierarchi
    //aby w Personrepository metodzie add poleciał
    //i przerwał transakcję
    public void addPerson(Person person){
        try {
            personRepository.add(person);
        }catch (ConstraintViolationException e){
            Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
            errors.forEach(er ->{
                System.out.println(er.getPropertyPath() + " "
                        + er.getInvalidValue() + " "
                        + er.getMessage());
            });
        }
    }
}
