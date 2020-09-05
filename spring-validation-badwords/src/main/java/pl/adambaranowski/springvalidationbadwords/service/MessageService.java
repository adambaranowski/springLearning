package pl.adambaranowski.springvalidationbadwords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import pl.adambaranowski.springvalidationbadwords.constraint.group.Draft;
import pl.adambaranowski.springvalidationbadwords.model.Message;
import pl.adambaranowski.springvalidationbadwords.model.Project;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;


@Service
public class MessageService {

    private Validator validator;

    @Autowired
    public MessageService(Validator validator) {
        this.validator = validator;
    }

    public boolean verifyMessage(Message message){

        Errors errors = new BeanPropertyBindingResult(message, "message");
        validator.validate(message, errors);

        if(errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            //allErrors.forEach(System.out::println);
            return false;
        }
        else {
            return true;
        }
    }


}
