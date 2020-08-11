package pl.adambaranowski.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    BookDaoImpl(){

    }

    @Override
    public void save(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Book get(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        return book;
    }
}
