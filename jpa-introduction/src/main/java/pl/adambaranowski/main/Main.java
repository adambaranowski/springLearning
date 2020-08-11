package pl.adambaranowski.main;

import pl.adambaranowski.dao.BookDao;
import pl.adambaranowski.dao.BookDaoImpl;
import pl.adambaranowski.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("123456789", "Wilk z Wall street", "jordan Belfort");
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved");
        bookDao.cleanUp();
    }
}
