package pl.adambaranowski.springvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import pl.adambaranowski.springvalidation.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {
    private Set<Person> people;

    private Validator validator;

    @Autowired
    public PersonService(Validator validator) {
        this.validator = validator;
        this.people = new HashSet<>();
    }

    public void addPerson(Person person){
        Errors errors = new BeanPropertyBindingResult(person, "person");
        validator.validate(person, errors);
        if(errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            allErrors.forEach(objectError -> {
                System.out.print(objectError);
                System.out.println("***");
                System.err.println(objectError.getDefaultMessage());

            });
        }else {
            people.add(person);
        }

    }

    public Set<Person> getPeople() {
        return people;
    }
}
