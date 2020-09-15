package pl.adambaranowski.validationwithjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adambaranowski.validationwithjpa.model.Person;
import pl.adambaranowski.validationwithjpa.repository.PersonRepository;
import pl.adambaranowski.validationwithjpa.service.PersonService;

@SpringBootApplication
public class ValidationWithJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(ValidationWithJpaApplication.class, args);

        Person person = new Person("Jan", null, "zlyEmail", 0);
        PersonService personService = ctx.getBean(PersonService.class);
        personService.addPerson(person);
        ctx.close();
    }

}
