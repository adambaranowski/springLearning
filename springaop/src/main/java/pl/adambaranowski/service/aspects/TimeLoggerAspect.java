package pl.adambaranowski.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class TimeLoggerAspect {
    @Around("execution(* pl.adambaranowski.service.BookRepository.* (..))")
    public Object measureExecTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant before = Instant.now();
        // @Before
        try {
            Object result = pjp.proceed();
            // @After
            return result;
            //}catch (Throwable e) {
            //  @AfterThrowing, gdyby nie było throws
            //}
        } finally {
            // @AfterReturning
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
    }

}
