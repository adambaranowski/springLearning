package com.adambaranowski.jpaspringboot.dao;

import com.adambaranowski.jpaspringboot.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

//    @PersistenceUnit
////    private EntityManagerFactory entityManagerFactory;
////
////    Korzystając z LocalContainerEntityManagerFactoryBean, co
////    jest opcją domyślną korzystając ze Spring Boota, jest to
////    możliwe, ponieważ Spring pełni w tej sytuacji rolę
////    kontenera w rozumieniu tego co znamy z Javy EE.
////    Zgodnie ze specyfikacją JPA możemy w tej sytuacji
////    wstrzykiwać do naszych klas DAO bezpośrednio obiekty
////    EntityManager zamiast EntityManagerFactory.
////    Robimy to korzystając z adnotacji @PersistenceContext.

    @PersistenceContext
    private EntityManager entityManager;

    BookDaoImpl(){

    }

    //Transactional zapewnia automatyczną obsługę transakcji
    //bez tego rzuciłby wyjątek
//    java.lang.IllegalStateException: Not allowed to create transaction
//    on shared EntityManager - use Spring transactions or EJB
//    CMT instead.
//    Mówi on o tym, że jeśli korzystamy ze wstrzykiwania obiektów
//    EntityManager bezpośrednio do komponentów poprzez
//    @PersistenceContext, rolę zarządzania transakcjami również
//    przejmuje kontener (w naszym przypadku Spring).
//    Samo usunięcie kodu związanego z transakcjami nie wystarczy,
//    musimy dodać specjalną adnotację @Transactional, która sprawi,
//    że transakcja rozpocznie się przed wejściem do metody,
//    a commit wykona się po jej wywołaniu. Adnotację tę można
//    dodać na poziomie pojedynczych metod lub na poziomie klasy,
//    wtedy transakcyjne będą wszystkie zawarte w niej metody.
//    Zwróć również uwagę na to, że ze względu na korzystanie z
//    EntityManagera zarządzanego przez Springa pomijamy kwestię
//    wywoływania za każdym razem
//    metody entityManager.close() - to już nie nasza rola.
    @Transactional
    @Override
    public void save(Book book) {
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        /////EntityTransaction entityTransaction = entityManager.getTransaction();
        /////entityTransaction.begin();
        entityManager.persist(book);
        //////entityTransaction.commit();
        //entityManager.close();
    }

    @Override
    public Book get(Long id) {
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Transactional
    @Override
    public void update(Book book) {
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        entityManager.merge(book);
//        tx.commit();
//        entityManager.close();
        entityManager.merge(book);
    }
    //merge utworzy obiekt jeżeli w bazie nie ma takiego o takim id

    @Transactional
    public void updateIfExist(Book book){
        Book find = entityManager.find(Book.class, book.getId());
        if(find!=null){
            find.setAuthor(book.getAuthor());
            find.setId(book.getId());
            find.setIsbn(book.getIsbn());
            find.setTitle(book.getTitle());
        }
    }




//    @Override
//    public void remove(Long bookId)
//    {
//        EntityManager em = emFactory.createEntityManager();
//        EntityTransaction tx = entityManager.getTransaction();
//        Book toRemove = entityManager.find(Book.class, bookId);
//        tx.begin();
//        entityManager.remove(toRemove);
//        tx.commit();
//        entityManager.close();
//    }

    @Transactional
    public void remove(Long bookId){
        Book toRemove = entityManager.find(Book.class, bookId);
        entityManager.remove(toRemove);
    }
}
