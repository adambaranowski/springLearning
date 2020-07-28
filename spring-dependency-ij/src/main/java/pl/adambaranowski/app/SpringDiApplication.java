package pl.adambaranowski.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.adambaranowski.beans.printers.MessagePrinter;

//@ComponentScan(basePackageClasses = MessagePrinter.class)
@ComponentScan(basePackages = "pl.adambaranowski")
@Configuration
public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                //new AnnotationConfigApplicationContext(ApplicationConfig.class);
                //PO PRZENIESIOENIU TUTAJ KONFIGURACJI
                new AnnotationConfigApplicationContext(SpringDiApplication.class);
        MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
        messagePrinter.print();
        ctx.close();
    }

}
