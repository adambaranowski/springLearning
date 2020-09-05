package pl.adambaranowski.springvalidationbadwords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.adambaranowski.springvalidationbadwords.constraint.group.Draft;
import pl.adambaranowski.springvalidationbadwords.constraint.group.Full;
import pl.adambaranowski.springvalidationbadwords.model.Project;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Service
public class ProjectService {
    private Validator validator;

    @Autowired
    public ProjectService(javax.validation.Validator validator) {
        this.validator = validator;
    }

    public boolean validateDraft(Project project){

        //for spring validator must be errors
        Errors errors = new BeanPropertyBindingResult(project, "project");

        //for javax validator must be set of errors
        Set<ConstraintViolation<Project>> validateErrors = validator.validate(project, Draft.class);
        validateErrors.forEach(err -> System.out.println(err.getPropertyPath() + " " + err.getMessage()));
        return validateErrors.isEmpty()? true:false;
    }

    public boolean validateFull(Project project){
        Set<ConstraintViolation<Project>> validate = validator.validate(project, Full.class);
        validate.forEach(err -> System.out.println(err.getPropertyPath() + " " + err.getMessage()));
        return validate.isEmpty()? true : false;
    }

}
