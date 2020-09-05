package pl.adambaranowski.springvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.adambaranowski.springvalidation.model.Person;
import pl.adambaranowski.springvalidation.service.PersonService;

@SpringBootApplication
public class SpringValidationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringValidationApplication.class, args);
        PersonService personService = run.getBean(PersonService.class);

        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 34);
        personService.addPerson(person1);

        Person person2 = new Person("Anna", null, "zlyEmail", 5);
        personService.addPerson(person2);

        System.out.println("People " + personService.getPeople().size());
        for(Person p: personService.getPeople()) {
            System.out.println(p);
        }

        run.close();


    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
