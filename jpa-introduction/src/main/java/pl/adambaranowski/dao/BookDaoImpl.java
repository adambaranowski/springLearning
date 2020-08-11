package pl.adambaranowski.dao;

import pl.adambaranowski.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {


    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public BookDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();

    }

    @Override
    public Book get(Long id) {
       return entityManager.find(Book.class, id);
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
