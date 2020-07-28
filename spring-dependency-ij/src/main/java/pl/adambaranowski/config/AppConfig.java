package pl.adambaranowski.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("messageFile")
    public String configFileName(){
        return "/message.txt";
    }

    @Bean
    @Qualifier("randomNumber")
    public int getRandomNumber(){
        return new Random().nextInt();
    }
}
