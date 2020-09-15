package pl.adambaranowski.springexercisedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SpringExerciseDiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringExerciseDiApplication.class, args);
        LinguController bean = ctx.getBean(LinguController.class);
        bean.mainLoop();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
