package pl.adambaranowski.service;

import org.springframework.stereotype.Component;
import pl.adambaranowski.model.Book;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class BookRepository implements GenericRepository<String, Book>   {

    private List<Book> books;

    Random random = new Random();

    public BookRepository(){
        books = new LinkedList<>();
    }

    @Override
    public Book get(String isbn) {
        if(isbn == null || isbn.length()!=13)
            throw new IllegalArgumentException("Provide Valid Isbn!");
        Book find = books.stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst()
                .orElseGet(Book::new);
        randomPause(1000);
        return find;
    }

    @Override
    public void add(Book book) {
        if(book == null || book.getIsbn() == null || book.getTitle() == null || book.getAuthor() == null)
            throw new IllegalArgumentException("Book cannot have null fields");
        randomPause(1000);
        books.add(book);
    }

    private void randomPause(int maxTime) {
        try {
            Thread.sleep(new Random().nextInt(maxTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
