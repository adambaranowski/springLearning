package pl.adambaranowski;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.adambaranowski.dao.BookDao;
import pl.adambaranowski.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringJpaApplication.class);
        BookDao bookDao = ctx.getBean(BookDao.class);

        Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
        bookDao.save(book);
        //odczytujemy
        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);

        Thread.sleep(5000);
        ctx.close();

    }
}
