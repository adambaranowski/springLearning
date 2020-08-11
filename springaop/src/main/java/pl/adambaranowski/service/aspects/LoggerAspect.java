package pl.adambaranowski.service.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* pl.adambaranowski.service.BookRepository.*(..))")
    public void logInfoBefore(){
        System.out.print("Log Before");
    }

    @After("execution(* pl.adambaranowski.service.BookRepository.*(..))")
    public void logInfoAfter() {
        System.out.println("Method executed ");
    }

    @AfterThrowing("execution(* pl.adambaranowski.service.BookRepository.*(..))")
    public void logError() {
        System.out.println("Method finished with error ");
    }

    @AfterReturning("execution(* pl.adambaranowski.service.BookRepository.*(..))")
    public void logSuccess() {
        System.out.println("Method successfully returned");
    }
}
