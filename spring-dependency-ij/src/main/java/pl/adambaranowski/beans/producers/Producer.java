package pl.adambaranowski.beans.producers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//co możemy tym oznaczyć
//czyli pole, konstruktor, metode
@Target({
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE
})

//adnotacja wykorzystana w czasie wykonania
@Retention(RetentionPolicy.RUNTIME)

//typ adnotacji to qualifier
@Qualifier
public @interface Producer {

    ProducerType type();

    public enum ProducerType{
        SIMPLE, FILE;
    }
}
