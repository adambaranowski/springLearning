package pl.adambaranowski.jparelations.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.jparelations.model.User;
import pl.adambaranowski.jparelations.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(User user) {
        UserDetails details = user.getDetails();

//        Tym razem najpierw sprawdzamy, czy obiekt details nie
//        jest nullem i czy nie ma już ustawionego id - jeśli id
//        byłoby ustawione, to wskazywałoby to, że obiekt ten już
//        jest powiązany z innym Userem, ponieważ pole oznaczone
//        jest jako @GeneratedValue. a ze względu na relację jeden
//        do jeden, nie powinniśmy
//        próbować dopisać tych samych szczegółów do innego obiektu.


//        Jeśli obiekt User nie ma ustawionego pola details
//        (metoda user.getDetails() zwróci null) to
//        nic się nie stanie, możemy je utworzyć w naszej aplikacji
//        później i powiązać z konkretnym
//        użytkownikiem korzystając z metody update() naszego DAO
        if(details != null && details.getId()==null){
            entityManager.persist(details);
        }
        entityManager.persist(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        UserDetails details = user.getDetails();
        if(details != null){
            details = entityManager.merge(details);
            //musimy powiązać obiekt w stanie zarządzalnym
            //wynik merge z userem
            user.setDetails(details);
        }
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        User userToDelete = entityManager.merge(user);
        entityManager.remove(userToDelete.getDetails());
        entityManager.remove(userToDelete);
    }
}
