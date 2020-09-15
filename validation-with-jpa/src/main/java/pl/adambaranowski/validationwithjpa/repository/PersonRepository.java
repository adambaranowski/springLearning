package pl.adambaranowski.validationwithjpa.repository;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.validationwithjpa.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void add(Person person){
        entityManager.persist(person);
    }


}
