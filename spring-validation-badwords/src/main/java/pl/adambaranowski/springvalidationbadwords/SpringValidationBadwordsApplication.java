package pl.adambaranowski.springvalidationbadwords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.adambaranowski.springvalidationbadwords.model.Message;
import pl.adambaranowski.springvalidationbadwords.service.MessageService;

import javax.validation.Validator;

@SpringBootApplication
public class SpringValidationBadwordsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidationBadwordsApplication.class, args);
        MessageService msgService = ctx.getBean(MessageService.class);
        Message msg = new Message("Hello message", "Cholercia to brzydkie słowo kurwa");
        boolean verifyMessage = msgService.verifyMessage(msg);
        System.out.println("Wiadomość poprawma? " + verifyMessage);
        ctx.close();



        
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}

